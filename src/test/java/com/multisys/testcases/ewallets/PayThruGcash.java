package com.multisys.testcases.ewallets;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.multisys.base.Page;
import com.multisys.pages.ctxpay.CTXPayPage;
import com.multisys.pages.ewallets.Ewallets;
import com.multisys.pages.ewallets.GcashPage;
import com.multisys.testcases.PlaceOrder;
import com.multisys.utilities.Utilities;

public class PayThruGcash extends Page {

	@Test
	public void payThruGcash() throws Exception {

		if (!Utilities.isTestRunnable("payThruGcash", excel)) {
			throw new SkipException("Skipping the test " + "payThruGcash" + " as the Run mode is NO");
		}

		PlaceOrder order = new PlaceOrder();
		order.addProductToCart();
		order.checkout();
		order.enterBillingAddress();

		CTXPayPage ctx = new CTXPayPage();
		Ewallets e = ctx.ewalletsPayment();
		Assert.assertTrue(isElementPresent("EPgcash_XPAT"));

		GcashPage gcash = e.gcash();
		gcash.enterNumber();

		String url = Page.driver.getCurrentUrl();
		Assert.assertTrue(url.contains(OR.getProperty("gcashsite")));
	}

	@AfterTest
	public void openNewTab() throws InterruptedException, AWTException {
		if (!Utilities.isTestRunnable("payThruGcash", excel)) {
			throw new SkipException("Skipping the test " + "payThruGcash" + " as the Run mode is NO");
		}
		Page.newTab();

		Assert.assertTrue(isElementPresent("hometab_XPATH"));
	}

}
