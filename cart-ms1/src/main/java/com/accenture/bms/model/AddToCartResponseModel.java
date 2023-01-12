package com.accenture.bms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddToCartResponseModel {

	private String orderId;
	private String cartId;
	private String createDate;
	private String code;
	private String errorMessage;
	private List<CartItem> items;

}
