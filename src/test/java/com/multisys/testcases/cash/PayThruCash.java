package com.multisys.testcases.cash;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.multisys.base.Page;
import com.multisys.pages.ctxpay.CTXPayPage;
import com.multisys.testcases.PlaceOrder;
import com.multisys.utilities.Utilities;

public class PayThruCash extends Page {

	@Test
	public void payThruCash() throws Exception {
		if (!Utilities.isTestRunnable("payThruCash", excel)) {
			throw new SkipException("Skipping the test " + "payThruCash" + " as the Run mode is NO");
		}
		PlaceOrder order = new PlaceOrder();
		order.addProductToCart();
		order.checkout();
		order.enterBillingAddress();

		CTXPayPage ctx = new CTXPayPage();
		ctx.cashPayment();
		Assert.assertTrue(isElementPresent("CP_XPATH"));
	}

	@AfterTest
	public void openNewTab() throws InterruptedException, AWTException {
		if (!Utilities.isTestRunnable("payThruCash", excel)) {
			throw new SkipException("Skipping the test " + "payThruCash" + " as the Run mode is NO");
		}
		Page.newTab();
		Assert.assertTrue(isElementPresent("hometab_XPATH"));
	}

}
