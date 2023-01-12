package com.javasession.bms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddToCartResponseModel {

	private String orderId;
	private String cartId;
	private String creationDate;
	private String code;
	private String errorMessage;
	private List<BundleItem> bundleItems;

}
