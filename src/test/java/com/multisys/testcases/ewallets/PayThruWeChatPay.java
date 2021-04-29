package com.multisys.testcases.ewallets;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.multisys.base.Page;
import com.multisys.pages.ctxpay.CTXPayPage;
import com.multisys.pages.ewallets.Ewallets;
import com.multisys.testcases.PlaceOrder;
import com.multisys.utilities.Utilities;

public class PayThruWeChatPay extends Page {

	@Test
	public void payThruWeChatPay() throws Exception {
		if (!Utilities.isTestRunnable("payThruWeChatPay", excel)) {
			throw new SkipException("Skipping the test " + "payThruWeChatPay" + " as the Run mode is NO");
		}
		PlaceOrder order = new PlaceOrder();
		order.addProductToCart();
		order.checkout();
		order.enterBillingAddress();

		CTXPayPage ctx = new CTXPayPage();
		Ewallets e = ctx.ewalletsPayment();
		e.weChatPay();

	}

	@AfterTest
	public void openNewTab() throws InterruptedException, AWTException {
		if (!Utilities.isTestRunnable("payThruWeChatPay", excel)) {
			throw new SkipException("Skipping the test " + "payThruWeChatPay" + " as the Run mode is NO");
		}
		Page.newTab();
		Assert.assertTrue(isElementPresent("hometab_XPATH"));
	}

}
