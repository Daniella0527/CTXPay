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

public class PayThruGrabPay extends Page {

	@Test
	public void payThruGrabPay() throws Exception {

		if (!Utilities.isTestRunnable("payThruGrabPay", excel)) {
			throw new SkipException("Skipping the test " + "payThruGrabPay" + " as the Run mode is NO");
		}

		PlaceOrder order = new PlaceOrder();
		order.addProductToCart();
		order.checkout();
		order.enterBillingAddress();

		CTXPayPage ctx = new CTXPayPage();
		Ewallets e = ctx.ewalletsPayment();
		e.grabPay();
	}

	 @AfterTest
		public void openNewTab() throws InterruptedException, AWTException {
			 if (!Utilities.isTestRunnable("payThruGrabPay", excel)) {
					throw new SkipException("Skipping the test " + "payThruGrabPay" + " as the Run mode is NO");
				}
			
			newTab("testsiteurl");
			
			Assert.assertTrue(isElementPresent("hometab_XPATH"));
		} 

	}

