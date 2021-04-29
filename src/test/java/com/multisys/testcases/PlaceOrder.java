package com.multisys.testcases;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import com.multisys.base.Page;
import com.multisys.pages.CartPage;
import com.multisys.pages.CheckoutPage;
import com.multisys.pages.PayForOrderPage;
import com.multisys.pages.ProductDetailsPage;
import com.multisys.pages.ShopPage;


public class PlaceOrder extends Page{

	
	public void addProductToCart() throws Exception {
		ShopPage shop = Page.menu.gotoShop();
		ProductDetailsPage pdpage = shop.gotoProductDetails();
		
		pdpage.EnterQuantity();
		Thread.sleep(2000);
		pdpage.AddToCart();
		Assert.assertTrue(isElementPresent("PRviewcart_XPATH"));
		
	}	
	
	public void checkout(){
		
		CartPage cart = Page.menu.gotoCart();
		cart.proceedToCheckout();
		Assert.assertTrue(isElementPresent("CHplaceorderbtn_XPATH"));
	}
	
	public void enterBillingAddress() throws Exception{
		CheckoutPage checkout = new CheckoutPage();
		checkout.EnterBillingAddress();
		Thread.sleep(2000);	
		checkout.placeOrder();
		Assert.assertTrue(isElementPresent("PFOpaynowbtn_XPATH"));
		
		PayForOrderPage pfo = new PayForOrderPage();
		pfo.paynow();
		Assert.assertTrue(isElementPresent("CTXlogo_XPATH"));
		
	}
	
	}
