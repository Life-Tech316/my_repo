package com.ibm.asset.ib.model.bank;

import java.util.UUID;

import lombok.Data;

@Data
public class BranchModel {
	private UUID id;
	private String code;
	private String name;
	private String halfKana;
	private BankModel bank = new BankModel();
	
	public BranchModel() {}
	public BranchModel(UUID id,String bankcode,String code,String name,String halfKana) {
		this.id = id;
		this.code= code;
		this.name = name;
		this.halfKana=halfKana;
		
		bank.setCode( bankcode);
	}
	
	
}
