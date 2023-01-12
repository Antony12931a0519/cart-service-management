package com.accenture.bms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Children {

	private long quantity;
	private String id;
	private List<ProductDetails> productDetails;
	

}
