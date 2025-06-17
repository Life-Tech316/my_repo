package com.ibm.asset.ib.config;


import lombok.Data;

@Data
public class APIConfig {
	private String host;
	
	private int port;
	
	private String apiBanks;
	private String apiBranches;
	private String apiApplications;
	private String apiLogin;
	private String apiBalanceAll;
	
}
