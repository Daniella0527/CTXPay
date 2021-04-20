package com.multisys.pages.shop;

import com.multisys.base.Page;

public class ShopPage extends Page {

	public ProductDetailsPage gotoProductDetails() {

		click("SHproduct_XPATH");

		return new ProductDetailsPage();
	}

	public void SortProducts(String sortby) {

		type("SHsort_XPATH", sortby);
	}

	public void AddToCart() {

		click("SHaddtocart_XPATH");
	}
	
	public void ViewCart() {

		click("SHviewcart_XPATH");
	}
	
}
