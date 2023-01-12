package com.javasession.bms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddToCartRequestModel {
	private List<BundleItem> bundleItems;

}
