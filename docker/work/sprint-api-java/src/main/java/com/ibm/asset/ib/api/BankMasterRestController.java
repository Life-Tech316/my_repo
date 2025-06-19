package com.ibm.asset.ib.api;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ibm.asset.ib.model.bank.BankModel;
import com.ibm.asset.ib.model.bank.BranchModel;

import lombok.Data;

// TODO API間のデータ引き渡しは再整理が必要。特にModelとJsonObjectの詰め替えは現状だと
//      箱の詰め替えコード作成という本質的でない作業が増える
@Data
class BankMaster {
	private List<BankModel> banks =new ArrayList<BankModel>();
}
@Data
class BranchMaster {
	private List<BranchModel> branches =new ArrayList<BranchModel>();
}

@RestController
public class BankMasterRestController  extends AbstractApiController {
    private final RestOperations restOperations;
    
    @Autowired
    private StringRedisTemplate redisTemplate;
    


    public BankMasterRestController(RestTemplateBuilder restTemplateBuilder) {
    	this.restOperations  = restTemplateBuilder.build();
    }
    
    @GetMapping("/api/ib/v1/banks")
    public ResponseEntity<List<BankModel>> getAllBanks(){
    	System.out.println("call \"/api/ib/v1/banks");

    	List<BankModel> json=new ArrayList<BankModel>();
    	
    	final String rkey="bank:";
    	long st=System.currentTimeMillis();

    	//
    	// check cache
    	if(redisTemplate.hasKey( rkey)) {
        	JsonObject obj= new Gson().fromJson(
        			redisTemplate.opsForValue().get( rkey),
        			JsonObject.class);
        	for(JsonElement v:obj.get("banks").getAsJsonArray()) {
        		BankModel model = new Gson().fromJson( v, BankModel.class);
        		json.add( model);
        	}
        	long et=System.currentTimeMillis();
        	System.out.println( (et-st) + " ms");
        	
        	return ResponseEntity.ok(json);
    	}
    	//
    	// call API
    	String api = config.getApiBanks();
    	System.out.println("api " + api);
    	String url = buildURL( api);
    	System.out.println("call " + url);

    	ResponseEntity<String> result = restOperations.getForEntity(url, String.class);
    	long et=System.currentTimeMillis();
    	System.out.println( (et-st) + " ms");
    	st=et;
    	JsonObject obj= new Gson().fromJson(result.getBody(), JsonObject.class);
    	for(JsonElement v:obj.get("banks").getAsJsonArray()) {
    		BankModel model = new Gson().fromJson( v, BankModel.class);
    		model.setId( null);
    		json.add( model);
    	}
    	et=System.currentTimeMillis();
    	System.out.println( (et-st) + " ms");
    	
        redisTemplate.opsForValue().set( rkey, result.getBody());
    	
    	return ResponseEntity.ok(json);
    }
    
    @GetMapping("/api/ib/v1/{bankCode}/branches")
    public ResponseEntity<List<BranchModel>> branches(@PathVariable String bankCode) {
    	System.out.println("call /api/ib/v1/" + bankCode + "/branches");
    	List<BranchModel> json=new ArrayList<BranchModel>();
    	long st=System.currentTimeMillis();
    	String rkey="branch:" + bankCode;
    	
    	if(redisTemplate.hasKey( rkey)) {
        	JsonObject obj= new Gson().fromJson(
        			redisTemplate.opsForValue().get( rkey),
        			JsonObject.class);
        	for(JsonElement v:obj.get("branches").getAsJsonArray()) {
        		BranchModel model = new Gson().fromJson( v, BranchModel.class);
        		json.add( model);
        	}
        	long et=System.currentTimeMillis();
        	System.out.println( (et-st) + " ms");
        	
        	return ResponseEntity.ok(json);
    	}

    	Map<String, String> vars = new HashMap<>();
    	vars.put("code", bankCode);
    	// TODO Springで受けるようなパスにパラメータを埋めたいが、疎通できず
    	// String url = "http://192.168.11.15:9090/api/23bc46b1-71f6-4ed5-8c54-816aa4f8c502/master/{bankcode}/branchs";

    	//
    	// call API
    	String api = config.getApiBranches();
    	System.out.println("api " + api);
    	String url = buildURL( api);
    	System.out.println("call " + url);
    	url += "?code=" + bankCode;
    	ResponseEntity<String> result = restOperations.getForEntity(url, String.class);
    	long et=System.currentTimeMillis();
    	System.out.println( (et-st) + " ms");
    	st=et;
    	JsonObject obj= new Gson().fromJson(result.getBody(), JsonObject.class);
    	for(JsonElement v:obj.get("branches").getAsJsonArray()) {
    		BranchModel model = new Gson().fromJson( v, BranchModel.class);
    		json.add( model);
    	}
    	et=System.currentTimeMillis();
    	System.out.println( (et-st) + " ms");
    	
        redisTemplate.opsForValue().set( rkey, result.getBody());
    	
    	return ResponseEntity.ok(json);
    }
    
    @PostMapping("/api/ib/v1/banks/file")
    public ResponseEntity<Map<String, Integer>> post(
            @RequestParam("file") MultipartFile multipartFile){
		System.out.println( multipartFile.getOriginalFilename());
    	if(multipartFile.getOriginalFilename().equals("branch.csv")) {
        	// TODO サイズの大きなファイルはOpenWhiskで拒否される
        	String url = "http://192.168.11.15:9090/api/23bc46b1-71f6-4ed5-8c54-816aa4f8c502/master/branchs";
    		
        	BranchMaster param = new BranchMaster();
    		BufferedReader br=null;
    		try {		    
    		    byte[] bytes = multipartFile.getBytes();
    		    InputStream is=new ByteArrayInputStream( bytes);
    	        InputStreamReader stream = new InputStreamReader(is,"UTF-8");
    	        br = new BufferedReader(stream);
    	
    	
    			CSVParser parse = null;
    	        parse = CSVFormat.EXCEL.parse(br);
    	        List<CSVRecord> recordList = parse.getRecords();
    	        for (CSVRecord record : recordList) {
    	            String bankcode = record.get( 0);
    	            String code = record.get( 1);
    	            
    	            String hkana = record.get( 2);	            
    	            String name = record.get( 3);
    	            
    	            BranchModel branch=new BranchModel( null, bankcode, code, name, hkana);    	            
    	        	param.getBranches().add( branch);
    	        }
    	        ResponseEntity<Map> result = restOperations.postForEntity(url, param, Map.class); 

    	        HttpStatus responseHttpStatus = result.getStatusCode();
    	        System.out.println( responseHttpStatus);
    	        Map<String,Integer> map=result.getBody();
    	        System.out.println( map.get("registered"));
    	        
    			return ResponseEntity.ok(map);
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
    	}
    	// 
    	//
    	// call API
    	String api = config.getApiBanks();
    	System.out.println("api " + api);
    	String url = buildURL( api);
    	System.out.println("call " + url);
    	//String url = "http://192.168.11.15:9090/api/23bc46b1-71f6-4ed5-8c54-816aa4f8c502/master/banks";
		
		BankMaster param = new BankMaster();
		BufferedReader br=null;
		try {		    
		    byte[] bytes = multipartFile.getBytes();
		    InputStream is=new ByteArrayInputStream( bytes);
	        InputStreamReader stream = new InputStreamReader(is,"UTF-8");
	        br = new BufferedReader(stream);
	
	
			CSVParser parse = null;
	        parse = CSVFormat.EXCEL.parse(br);
	        List<CSVRecord> recordList = parse.getRecords();
	        for (CSVRecord record : recordList) {
	            String code = record.get( 0);
	            String hkana = record.get( 2);	            
	            String name = record.get( 3);
	            
	            BankModel bank=new BankModel( code, name, hkana);
	        	param.getBanks().add( bank);
	        }
	        ResponseEntity<Map> result = restOperations.postForEntity(url, param, Map.class); 

	        HttpStatus responseHttpStatus = result.getStatusCode();
	        System.out.println( responseHttpStatus);
	        Map<String,Integer> map=result.getBody();
	        System.out.println( map.get("registered"));
	        
			return ResponseEntity.ok(map);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
		return ResponseEntity.badRequest().build();
    }
}
