package com.ibm.asset.ib.model.bank;

import java.util.UUID;

import lombok.Data;


@Data
public class BankModel {
	private UUID id;
	private String code;
	private String name;
	private String halfKana;
	
	public BankModel() {}
	public BankModel(UUID id,String code,String name,String halfKana) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.halfKana = halfKana;
	}
	public BankModel(String code,String name,String halfKana) {
		this.code = code;
		this.name = name;
		this.halfKana = halfKana;
	}
}
