package com.ibm.asset.ib.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestOperations;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ibm.asset.ib.model.contract.UserAccountModel;
import com.ibm.asset.ib.model.dmt.ApplicationPackageModel;
import com.ibm.asset.ib.model.dmt.ApplicationPackageStatusModel;
import com.ibm.asset.ib.model.user.UserAuthManagement;
import com.ibm.asset.ib.service.PersonalInfoMaker;
import com.ibm.asset.ib.util.JsonUtilOss;

import lombok.Data;

@Data
class ApplicationWrapper {
	private UserAccountModel user;
	private ApplicationPackageModel applicationPackage;
}

@Validated
@RestController
public class MTApplicationRestController extends AbstractApiController {
	private final RestOperations restOperations;

	@Autowired
	private PersonalInfoMaker pim;

	public MTApplicationRestController(RestTemplateBuilder restTemplateBuilder) {
		this.restOperations = restTemplateBuilder.build();
	}

	@PostMapping("/api/ib/v1/mt/application/beneficiary")
	public ResponseEntity<String> queryBeneficiary(@RequestBody ApplicationPackageModel model) {
		System.out.println("/api/ib/v1/mt/application/beneficiary");

		// TODO 本来は共通側に移動すべき
		// String url =
		// "http://192.168.11.15:9090/api/23bc46b1-71f6-4ed5-8c54-816aa4f8c502/mt/application";
		// ResponseEntity<Map> result = restOperations.postForEntity(url, param,
		// Map.class);

		String name = pim.getName();
		System.out.println("name=" + name);

		return ResponseEntity.ok(name);
	}

	// TODO REST APIの名前の再整理
	@SuppressWarnings("unchecked")
	@PostMapping("/api/ib/v1/mt/application/commit")
	public ResponseEntity<Map<String, Object>> commit(@RequestBody Map<String, Object> map) {
		System.out.println("/api/ib/v1/mt/application/commit");
		
		// セッションチェック
		Map<String, Object> json = new HashMap<String, Object>();
		if (map == null || !map.containsKey("session")) {
			return ResponseEntity.badRequest().body(json);
		}
		String session = (String)map.get("session");
		String user_id = UserAuthManagement.getUserFromSession(session);
		if (user_id == null) {
			return ResponseEntity.status(500).body(json);
		}

		// 振込先銀行を取得
		// 振込先銀行が同じ場合は存在チェック
		// 口座から出金
		String api = config.getApiApplications();
		String url = buildURL(api);
		System.out.println(url);
		JsonObject request = new JsonObject();
		request.addProperty("user_id", user_id);
		request.addProperty("amount", 
				((List<Map<String, String>>)map.get("applications")).get(0).get("amount"));

		ResponseEntity<String> result = null;
		try {
			result = restOperations.postForEntity(url, request.toString(), String.class);
			System.out.println(result);
			JsonObject retObj = new Gson().fromJson(result.getBody(), JsonObject.class);
			if (retObj.has("id")) {
				json.put("id", retObj.get("id").getAsString());
			}
			return ResponseEntity.ok(json);
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(json);
		} catch (Exception e2) {
			e2.printStackTrace();
			return ResponseEntity.status(500).body(json);
		}
		
		// 振込先銀行が同じ場合は入金処理
		// 振込先銀行が異なる場合は他行振込処理
	}
}
