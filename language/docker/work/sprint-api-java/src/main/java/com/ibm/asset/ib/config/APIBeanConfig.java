package com.ibm.asset.ib.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@PropertySource(value = "classpath:api.yml")
@PropertySource(value = "classpath:api.properties")
//@ContextConfiguration(initializers = ConfigFileApplicationContextInitializer.class)
public class APIBeanConfig {

	@Value("${api.node.host}")
	private String host;
	
	@Value("${api.node.port}")
	private int port;
	
	@Value("${api.services.banks}")
	private String apiBanks;

	@Value("${api.services.branchs}")
	private String apiBranches;

	@Value("${api.services.application}")
	private String apiApplications;

	@Value("${api.services.login}")
	private String apiLogin;
	
	@Value("${api.services.balanceAll}")
	private String apiBalanceAll;
	
	@Bean
	public APIConfig APIConfig() {
		APIConfig config=new APIConfig();
		config.setHost(host);
		config.setPort(port);
		config.setApiBanks(apiBanks);
		config.setApiBranches(apiBranches);
		config.setApiApplications(apiApplications);
		config.setApiLogin(apiLogin);
		config.setApiBalanceAll(apiBalanceAll);
		return config;
	}
}
