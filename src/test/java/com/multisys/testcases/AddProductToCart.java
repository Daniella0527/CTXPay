package com.multisys.testcases;


import org.testng.annotations.Test;

import com.multisys.base.Page;
import com.multisys.pages.shop.ShopPage;

public class AddProductToCart {

	@Test
	public void addProductToCart(){
		ShopPage shop = Page.menu.gotoShop();
		shop.AddToCart();
		shop.AddToCart();
		shop.ViewCart();
	}
}