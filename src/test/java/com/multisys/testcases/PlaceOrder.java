package com.multisys.testcases;


import java.util.Hashtable;

import org.testng.annotations.Test;

import com.multisys.base.Page;
import com.multisys.pages.CartPage;
import com.multisys.pages.checkout.CheckoutPage;
import com.multisys.pages.checkout.PayForOrderPage;
import com.multisys.pages.shop.ProductDetailsPage;
import com.multisys.pages.shop.ShopPage;
import com.multisys.utilities.Utilities;


public class PlaceOrder {
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void addProductToCart(Hashtable<String,String> data) throws InterruptedException {
		
		ShopPage shop = Page.menu.gotoShop();
		ProductDetailsPage pdpage = shop.gotoProductDetails();
		
		pdpage.EnterQuantity(data.get("Quantity"));
		Thread.sleep(2000);
		pdpage.AddToCart();
		
	}	
	
	@Test
	public void checkout(){
		CartPage cart = Page.menu.gotoCart();
		cart.proceedToCheckout();
	}
	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void enterBillingAddress(Hashtable<String,String> data) throws InterruptedException{
		CheckoutPage checkout = new CheckoutPage();
		checkout.EnterBillingAddress(data.get("First Name"),data.get("Last Name"), data.get("Company Name"),data.get("Country"), data.get("House # & Street name"), data.get("Barangay"), data.get("City"), data.get("Region"), data.get("Postal Code"), data.get("Phone Number"), data.get("Email Address"), data.get("Order Notes"));
		Thread.sleep(5000);
		checkout.placeOrder();
		PayForOrderPage pfo = new PayForOrderPage();
		pfo.paynow();
		
	}
	

}