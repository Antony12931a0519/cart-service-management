package com.javasession.bms.service;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javasession.bms.model.AddToCartRequestModel;
import com.javasession.bms.model.AddToCartResponseModel;

@Service
public class CartService {

	public  AddToCartResponseModel addItemsTocart(AddToCartRequestModel request) {
		AddToCartResponseModel response = new AddToCartResponseModel();

		InputStream inJson = AddToCartResponseModel.class.getResourceAsStream("/ms2-response.json");
		try {
			response = new ObjectMapper().readValue(inJson, AddToCartResponseModel.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	
}
