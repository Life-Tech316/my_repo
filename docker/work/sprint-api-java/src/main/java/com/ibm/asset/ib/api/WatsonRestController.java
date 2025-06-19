package com.ibm.asset.ib.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.CreateSessionOptions;
import com.ibm.watson.assistant.v2.model.DeleteSessionOptions;
import com.ibm.watson.assistant.v2.model.MessageInput;
import com.ibm.watson.assistant.v2.model.MessageOptions;
import com.ibm.watson.assistant.v2.model.MessageResponse;
import com.ibm.watson.assistant.v2.model.RuntimeEntity;
import com.ibm.watson.assistant.v2.model.SessionResponse;

@RestController
public class WatsonRestController extends AbstractApiController {

	final static String apiKey = "dFtJrI2QXBlk3nVvMaZ-1bpmK8iujMEgPQmfrvFfmVXp";
	final static String serviceUrl = "https://api.au-syd.speech-to-text.watson.cloud.ibm.com/instances/d46c1c85-65b1-4ab7-baf5-59637da73311";
//	final static String serviceUrl = "https://api.au-syd.speech-to-text.watson.cloud.ibm.com";

	final static String WA_API_KEY = "H-i0oPMUWBrrJZCntfwoYoQ6REa9uGHKlf984V_7ynMe";
	final static String WA_END_POINT = "https://api.au-syd.assistant.watson.cloud.ibm.com/instances/30f83128-fb22-41dd-b656-06baa7ec4314";
	private static String ASSISTANT_ID = "a777bd9a-2485-4f9b-a1a9-cf3cab410e0b";

	@GetMapping("/api/ib/v1/watson/auth")
	public ResponseEntity<Map<String, String>> getApiTokens() {
		// 本来はバック側に連携する。
		System.out.println("call \"/api/ib/v1/watson/auth");
		Map<String, String> json = new HashMap<String, String>();
		String token = "";
		IamAuthenticator authenticator = new IamAuthenticator(apiKey);
		token = authenticator.getToken();
		json.put("token", token);
		json.put("url", serviceUrl);

		
		if (token == null || token.isEmpty()) {
			return ResponseEntity.status(500).body(json);
		} else {
			return ResponseEntity.ok(json);
		}
	}

	@PostMapping("/api/ib/v1/watson/assistant")
	public ResponseEntity<Map<String, String>> recognizeMessage(@RequestBody Map<String, String> map) {
		System.out.println("call \"/api/ib/v1/watson/assistant");
		String message = map.get("message");

		System.out.println(message);
		Authenticator authenticator = new IamAuthenticator(WA_API_KEY);
		Assistant service = new Assistant("2019-10-07", authenticator);
		service.setServiceUrl(WA_END_POINT);
		String assistantId = ASSISTANT_ID; // replace with assistant ID

		// Create session.
		CreateSessionOptions createSessionOptions = new CreateSessionOptions.Builder(assistantId).build();
		SessionResponse session = service.createSession(createSessionOptions).execute().getResult();
		String sessionId = session.getSessionId();

		// Start conversation with empty message.
		MessageInput input = new MessageInput.Builder().text(message).build();
		MessageOptions messageOptions = new MessageOptions.Builder(assistantId, sessionId).input(input).build();
		MessageResponse response = service.message(messageOptions).execute().getResult();
//		System.out.println(response);

		// We're done, so we delete the session.
		DeleteSessionOptions deleteSessionOptions = new DeleteSessionOptions.Builder(assistantId, sessionId).build();
		service.deleteSession(deleteSessionOptions).execute();

		List<String> numList = new ArrayList<String>();
		Map<String, String> json = new HashMap<String, String>();
		for (RuntimeEntity s : response.getOutput().getEntities()) {
			switch (s.entity()) {
			case "銀行名":
				json.put("bankName", s.value());
				break;
			case "支店名":
				json.put("branchName", s.value());
				break;
			case "口座種別":
				json.put("accountType", s.value());
				break;
			case "sys-number":
				numList.add(s.value());
//				json.put("accountNum", s.value());
				break;
			case "sys-currency":
				json.put("amount", s.value());
				break;
			default:
				break;
			}
		}
		for (String s : numList) {
			if (s.equals(json.get("amount"))) {
				// 金額の場合は除外
				continue;
			} else if (s.length() > 5) {
				json.put("accountNum", s);
			}
		}

		System.out.println("---------------------------------------");
		if (json == null || json.isEmpty()) {
			return ResponseEntity.status(500).body(json);
		} else {
			return ResponseEntity.ok(json);
		}
	}

	@PostMapping("/api/ib/v1/watson/transffer")
	public ResponseEntity<Map<String, String>> transffer(@RequestBody Map<String, Object> map) {
		System.out.println(map);
		Map<String, String> json = new HashMap<String, String>();
		return ResponseEntity.ok(json);
	}
}
