package com.accenture.bms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BundleItem {
	private String item_code;
	private long quantity;
	private List<Details> details;
	private List<ChildComponent> child_components;
	
	

	

}
