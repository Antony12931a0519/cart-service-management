package com.accenture.bms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItem {
	private long id;
	private long quantity;
	private String itemId;

	private List<ProductDetails> productDetails;
	private List<Children> children;
	private String productCode;

}
