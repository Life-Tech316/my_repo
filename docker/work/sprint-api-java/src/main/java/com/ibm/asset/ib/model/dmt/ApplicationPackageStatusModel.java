package com.ibm.asset.ib.model.dmt;

import java.util.UUID;

import lombok.Data;

@Data
public class ApplicationPackageStatusModel {
	private UUID id;
	private String message;
}
