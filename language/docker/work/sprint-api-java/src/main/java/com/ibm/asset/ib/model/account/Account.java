package com.ibm.asset.ib.model.account;

import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class Account {
	private String subjectCode;
	@Pattern(regexp="^[0-9]{6,7}$")
	private String number;
	
	static public void main(String[] args) {
		
	}
}
