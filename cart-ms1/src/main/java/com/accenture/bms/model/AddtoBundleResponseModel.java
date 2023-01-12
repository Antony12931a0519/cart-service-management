package com.accenture.bms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class AddtoBundleResponseModel {


	private String orderId;
	private String cartId;
	private String creationDate;
	private String code;
	private String errorMessage;
	private List<BundleItem> bundleItems;


}
