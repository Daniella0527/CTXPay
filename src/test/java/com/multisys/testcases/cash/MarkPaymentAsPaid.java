package com.multisys.testcases.cash;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.multisys.base.Page;
import com.multisys.pages.ctxpay.CashPayment;
import com.multisys.utilities.Utilities;

public class MarkPaymentAsPaid extends Page {

	@Test
	public void markPaymentAsPaid() throws Exception {
		if (!Utilities.isTestRunnable("markPaymentAsPaid", excel)) {
			throw new SkipException("Skipping the test " + "markPaymentAsPaid" + " as the Run mode is NO");
		}
		
		CashPayment payment = new CashPayment();
		payment.markAsPaid();


	}
	
	 @AfterTest
		public void openNewTab() throws InterruptedException, AWTException {
			 if (!Utilities.isTestRunnable("markPaymentAsPaid", excel)) {
					throw new SkipException("Skipping the test " + "markPaymentAsPaid" + " as the Run mode is NO");
				}
			
			Page.newTab("testsiteurl");
			
			Assert.assertTrue(isElementPresent("hometab_XPATH"));
		} 

	}

