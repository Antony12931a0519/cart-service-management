package com.javasession.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javasession.bms.model.AddToCartRequestModel;
import com.javasession.bms.model.AddToCartResponseModel;
import com.javasession.bms.service.CartService;

@RestController
public class CartController {
	@Autowired
	private CartService cartService;

	@PostMapping("/addBundleItemsTocart")
	public AddToCartResponseModel addItemsToCart(@RequestBody AddToCartRequestModel request) {

		return cartService.addItemsTocart(request);
	}

}
