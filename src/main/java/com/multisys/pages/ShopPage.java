package com.multisys.pages;

import com.multisys.base.Page;

public class ShopPage extends Page {

	public ProductDetailsPage gotoProductDetails() {

		click("SHproduct_XPATH");
		return new ProductDetailsPage();
	}

	public void sortProducts(String sortby) {

		type("SHsort_XPATH", sortby);
	}
	

	public void addToCart() {

		click("SHaddtocart_XPATH");
	}
	
	public void viewCart() {

		click("SHviewcart_XPATH");
	}
	
}
