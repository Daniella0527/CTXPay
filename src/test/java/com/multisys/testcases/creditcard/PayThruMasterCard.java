package com.multisys.testcases.creditcard;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import com.multisys.base.Page;
import com.multisys.pages.ctxpay.CTXPayPage;
import com.multisys.pages.ctxpay.CreditCard;
import com.multisys.testcases.PlaceOrder;
import com.multisys.utilities.Utilities;

public class PayThruMasterCard extends Page {

	@Test()
	public void payThruMasterCard() throws Exception {
		if (!Utilities.isTestRunnable("payThruMasterCard", excel)) {
			throw new SkipException("Skipping the test " + "payThruMasterCard" + " as the Run mode is NO");
		}

		PlaceOrder order = new PlaceOrder();
		order.addProductToCart();
		order.checkout();
		order.enterBillingAddress();

		CTXPayPage ctx = new CTXPayPage();
		CreditCard card = ctx.creditCardPayment();
		
		Assert.assertTrue(isElementPresent("MPcheckoutbtn_XPATH"));
		card.enterCardDetails();
		
		Assert.assertTrue(isElementPresent("MPpaynowbtn_XPATH"));
		card.paynow();
		
	}

	 @AfterTest
	public void openNewTab() throws InterruptedException, AWTException {
		 if (!Utilities.isTestRunnable("payThruMasterCard", excel)) {
				throw new SkipException("Skipping the test " + "payThruMasterCard" + " as the Run mode is NO");
			}
		
		Page.newTab("testsiteurl");
		
		Assert.assertTrue(isElementPresent("hometab_XPATH"));
	} 

}