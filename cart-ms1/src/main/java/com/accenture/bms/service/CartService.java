package com.accenture.bms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.accenture.bms.model.AddToCartResponseModel;
import com.accenture.bms.model.AddtoBundleRequestModel;
import com.accenture.bms.model.AddtoBundleResponseModel;
import com.accenture.bms.model.BundleItem;
import com.accenture.bms.model.CartItem;
import com.accenture.bms.model.ChildComponent;
import com.accenture.bms.model.Children;
import com.accenture.bms.model.Details;
import com.accenture.bms.model.ProductDetails;

@Service
public class CartService {
	@Autowired
	private RestTemplate restTemplate;

	public AddToCartResponseModel addItemsToCart(AddtoBundleRequestModel request) {

		// restTemplate.getForEntity("http://localhost:9091/addBundleItemsTocart",
		// Addtoca)
		ResponseEntity<AddtoBundleResponseModel> response = restTemplate
				.postForEntity("http://localhost:9092/addBundleItemsTocart", request, AddtoBundleResponseModel.class);
		AddtoBundleResponseModel responseFromMs2 = response.getBody();
		AddToCartResponseModel finalResponse = new AddToCartResponseModel();
		finalResponse.setCartId(responseFromMs2.getCartId());
		finalResponse.setCode(responseFromMs2.getCode());
		finalResponse.setCreateDate(responseFromMs2.getCreationDate());
		finalResponse.setErrorMessage(responseFromMs2.getErrorMessage());
		finalResponse.setOrderId(responseFromMs2.getOrderId());

		List<BundleItem> bundleItems = responseFromMs2.getBundleItems();

		List<CartItem> items = new ArrayList<CartItem>();
		for (BundleItem bundleItem : bundleItems) {

			CartItem cartItem = new CartItem();
			cartItem.setItemId(bundleItem.getItem_code());
			cartItem.setQuantity(bundleItem.getQuantity());

			List<ProductDetails> productDetails = new ArrayList<ProductDetails>();
			List<Children> children = new ArrayList<>();

			List<Details> details = bundleItem.getDetails();
			List<ChildComponent> childComponents = bundleItem.getChild_components();

			for (Details detail : details) {
				ProductDetails product = new ProductDetails();
				product.setName(detail.getKey());
				product.setValue(detail.getValue());
				productDetails.add(product);
			}

			for (ChildComponent child : childComponents) {

				List<ProductDetails> productDetailsList = new ArrayList<ProductDetails>();
				Children chilrenObject = new Children();
				chilrenObject.setId(child.getItem_code());
				chilrenObject.setQuantity(child.getQuantity());

				for (Details detail : child.getDetails()) {
					ProductDetails productDetailsObj = new ProductDetails();
					productDetailsObj.setName(detail.getKey());
					productDetailsObj.setValue(detail.getValue());
					productDetailsList.add(productDetailsObj);
				}

				chilrenObject.setProductDetails(productDetailsList);
				children.add(chilrenObject);
			}

			cartItem.setChildren(children);
			cartItem.setProductDetails(productDetails);
			items.add(cartItem);

		}
		finalResponse.setItems(items);
		return finalResponse;

	}

}
