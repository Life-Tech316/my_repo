package com.ibm.asset.ib.model.dmt;

import java.util.UUID;

import javax.validation.Valid;

import com.ibm.asset.ib.model.account.Account;
import com.ibm.asset.ib.model.bank.BranchModel;

import lombok.Data;

@Data
public class ApplicationModel {
	private UUID id;
	private BranchModel branch = new BranchModel();
	@Valid
	private Account account = new Account();
	private String amount;
	private String beneficiary;
	
}
