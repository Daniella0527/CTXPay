package com.multisys.base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.multisys.pages.CartPage;
import com.multisys.pages.CheckoutPage;
import com.multisys.pages.ShopPage;

public class TopMenu extends Page{

	WebDriver driver;

	public TopMenu(WebDriver driver) {
		this.driver = driver;
	}

	public CartPage gotoCart() {
		Page.click("carttab_XPATH");
		return new CartPage();
	}

	public CheckoutPage gotoCheckout() {
		Page.click("checkouttab_XPATH");
		Assert.assertTrue(isElementPresent("CHhdr_XPATH"));
		return new CheckoutPage();
	}

	public ShopPage gotoShop() {
		Page.click("shoptab_XPATH");	
		return new ShopPage();

	}

}
