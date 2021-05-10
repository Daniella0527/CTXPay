package com.multisys.testcases.cash;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.multisys.base.Page;
import com.multisys.pages.ctxpay.CTXPayPage;
import com.multisys.pages.ctxpay.CashPayment;
import com.multisys.testcases.PlaceOrder;
import com.multisys.utilities.ExcelApiTest;
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
		
		CTXPayPage payment = new CTXPayPage();
		payment.cashPayment();
		
		verifyPayment("Cash Payments");
		CashPayment.getRefNum("CPrefNum_XPATH");
		
		
	}
	
	@AfterTest
	public void openNewTab() throws Exception {
		if (!Utilities.isTestRunnable("payThruCash", excel)) {
			
			throw new SkipException("Skipping the test " + "payThruCash" + " as the Run mode is NO");
		}
		
		String sheetName = "test_suite";
		ExcelApiTest eat = new ExcelApiTest(path);
		if (eat.getCellData(sheetName, "Runmode", 3).equalsIgnoreCase("Y")) {
			newTab("testpartnerurl");	
		}	else {
			newTab("testsiteurl");	
			Assert.assertTrue(isElementPresent("hometab_XPATH"));
	}
	}
}