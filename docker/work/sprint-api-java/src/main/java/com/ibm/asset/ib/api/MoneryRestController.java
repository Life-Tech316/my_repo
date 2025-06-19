package com.ibm.asset.ib.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestOperations;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ibm.asset.ib.model.user.UserAuthManagement;
import com.ibm.asset.ib.util.JsonUtilOss;

@RestController
public class MoneryRestController extends AbstractApiController {

	private final RestOperations restOperations;

	public MoneryRestController(RestTemplateBuilder restTemplateBuilder) {
		this.restOperations = restTemplateBuilder.build();
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/api/ib/v1/account/all")
	public ResponseEntity<Map<String, Object>> getBalanceInfoAll(@RequestBody Map<String, String> map) {
		System.out.println("call /api/ib/v1/account/all");

		Map<String, Object> json = new HashMap<String, Object>();
		if (map == null || !map.containsKey("session")) {
			return ResponseEntity.badRequest().body(json);
		}
		String session = map.get("session");
		String user_id = UserAuthManagement.getUserFromSession(session);
		if (user_id == null) {
			return ResponseEntity.status(500).body(json);
		}

		String api = config.getApiBalanceAll();
		String url = buildURL(api);
		JsonObject request = new JsonObject();
		request.addProperty("user_id", user_id);

		ResponseEntity<String> result = null;
		try {
			result = restOperations.postForEntity(url, request.toString(), String.class);
			System.out.println(result);
			JsonObject retObj = new Gson().fromJson(result.getBody(), JsonObject.class);
			List<Object> list = new ArrayList<Object>();
			if (!retObj.has("accountArray") || !retObj.get("accountArray").isJsonArray()) {
				return ResponseEntity.status(500).body(json);
			}
			for (JsonElement jelm : retObj.getAsJsonArray("accountArray")) {
				if (!jelm.isJsonObject()) {
					return ResponseEntity.status(500).body(json);
				}
				JsonObject jObj = jelm.getAsJsonObject();
				if (!jObj.has("account") || !jObj.get("account").isJsonArray()) {
					return ResponseEntity.status(500).body(json);
					
				}
				for (JsonElement jelm2 : jObj.getAsJsonArray("account")) {
					list.add(JsonUtilOss.convertObjectFromJson(jelm2));
				}
			}
			json.put("accountInfo", list);
			return ResponseEntity.ok(json);
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
			return ResponseEntity.status(500).body(json);
		} catch (Exception e2) {
			e2.printStackTrace();
			return ResponseEntity.status(500).body(json);
		}
	}
}
