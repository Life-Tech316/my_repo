package com.ibm.asset.ib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		System.out.println("次世代インターネットバンキング(プロトタイプ)");
		SpringApplication.run(MainApplication.class, args);
	}

}
