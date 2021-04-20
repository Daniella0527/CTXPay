package com.multisys.base;

import org.openqa.selenium.WebDriver;

import com.multisys.pages.CartPage;
import com.multisys.pages.HomePage;
import com.multisys.pages.SamplePage;
import com.multisys.pages.checkout.CheckoutPage;
import com.multisys.pages.shop.ShopPage;

public class TopMenu {

	/*
	 * 
	 * TopMenu ISA Page ???
	 * 
	 * HomePage HASA TopMenu AccountsPAge HASA TopMenu
	 * 
	 * Page HASA TopMenu
	 * 
	 * 
	 */

	WebDriver driver;

	public TopMenu(WebDriver driver) {

		this.driver = driver;
	}

	public HomePage gotoHome() {

		Page.click("hometab_XPATH");

		return new HomePage();

	}

	public CartPage gotoCart() {
		Page.click("carttab_XPATH");

		return new CartPage();
	}

	public CheckoutPage gotoCheckout() {
		Page.click("checkouttab_XPATH");

		return new CheckoutPage();
	}

	public SamplePage gotoSamplePage() {
		Page.click("samplepagetab_XPATH");

		return new SamplePage();
	}

	public ShopPage gotoShop() {
		Page.click("shoptab_XPATH");

		return new ShopPage();
	
	}

}
