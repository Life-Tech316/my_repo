package com.ibm.asset.ib.model.dmt;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import com.ibm.asset.ib.model.contract.UserAccountModel;

import lombok.Data;

@Data
public class ApplicationPackageModel {
	private UUID id;
	private long executedDate = 0;
	private long requestedDate = 0;
	@Valid
	private UserAccountModel user=new UserAccountModel();
	@Valid
	private List<ApplicationModel> applications =new ArrayList<ApplicationModel>();
}
