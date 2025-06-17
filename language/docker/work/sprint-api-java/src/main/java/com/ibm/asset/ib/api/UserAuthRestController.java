package com.ibm.asset.ib.api;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestOperations;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ibm.asset.ib.model.user.UserAuthManagement;

@RestController
public class UserAuthRestController extends AbstractApiController {

	private final RestOperations restOperations;

	public UserAuthRestController(RestTemplateBuilder restTemplateBuilder) {
		this.restOperations = restTemplateBuilder.build();
	}

	@PostMapping("/api/ib/v1/login/auth")
	public ResponseEntity<Map<String, String>> recognizeMessage(@RequestBody Map<String, String> map) {
		Map<String, String> json = new HashMap<String, String>();
		System.out.println("call /api/ib/v1/login/auth");
		String userid = map.get("userid");
		String password = map.get("password");
		System.out.println("user:" + userid + ",password:" + password);

		String api = config.getApiLogin();
		String url = buildURL(api);
		System.out.println(url);
		JsonObject request = new JsonObject();
		request.addProperty("user_id", userid);
		request.addProperty("password", password);
		System.out.println(request);
		ResponseEntity<String> result = null;
		try {
			result = restOperations.postForEntity(url, request.toString(), String.class);
			System.out.println(result);
			JsonObject retObj = new Gson().fromJson(result.getBody(), JsonObject.class);
			if (retObj.has("login_success")
					&& retObj.get("login_success").getAsBoolean()) {
				String token = RandomStringUtils.randomAlphanumeric(48);
				String user_name = retObj.get("user_name").getAsString();
				json.put("token", token);
				json.put("user_name", user_name);
				UserAuthManagement.pushUserAndSession(token, userid);
				return ResponseEntity.ok(json);
			} else {
				json.put("message", "ユーザーID または パスワード が間違っています。");
				return ResponseEntity.ok(json);
			}
		} catch (HttpClientErrorException e) {
			e.printStackTrace();
			json.put("message", "ユーザーID または パスワード が間違っています。");
			return ResponseEntity.status(500).body(json);
		}
	}
}
