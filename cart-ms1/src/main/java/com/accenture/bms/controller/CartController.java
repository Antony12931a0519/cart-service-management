package com.accenture.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.bms.model.AddToCartRequestModel;
import com.accenture.bms.model.AddToCartResponseModel;
import com.accenture.bms.model.AddtoBundleRequestModel;
import com.accenture.bms.service.CartService;

@RestController
public class CartController {
	@Autowired
	private CartService cartService;

	@PostMapping("/addBundleItemsTocart")
	public AddToCartResponseModel addItemsToCart(@RequestBody AddToCartRequestModel request) {

		AddtoBundleRequestModel bundleRequestModel = new AddtoBundleRequestModel();

		return cartService.addItemsToCart(bundleRequestModel);
	}

}
