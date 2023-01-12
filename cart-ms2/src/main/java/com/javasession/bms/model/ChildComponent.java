package com.javasession.bms.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChildComponent {

	private String item_code;
	private long quantity;
	private List<Details> details;

}
