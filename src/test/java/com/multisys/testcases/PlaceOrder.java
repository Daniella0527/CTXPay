package com.multisys.testcases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.multisys.pages.CartPage;
import com.multisys.pages.checkout.CheckoutPage;
import com.multisys.utilities.Utilities;

public class PlaceOrder {

	
	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void placeOrder(Hashtable<String,String> data){
		CartPage cart = new CartPage();
		cart.proceedToCheckout();
		CheckoutPage checkout = new CheckoutPage();
		checkout.EnterBillingAddress(data.get("First Name"),data.get("Last Name"), data.get("Company Name"),data.get("Country"), data.get("House # & Street name"), data.get("Barangay"), data.get("City"), data.get("Region"), data.get("Postal Code"), data.get("Phone Number"), data.get("Email Address"), data.get("Order Notes"));
		checkout.placeOrder();
	
	}
}