package com.multisys.pages.ctxpay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.multisys.base.Page;

public class CashPayment extends Page{
	static String refNum;

	public static void getRefNum(String locator) throws Exception {
		Thread.sleep(3000);
		refNum = getText(locator);
		
	}
	
	
	public void markAsPaid() throws Exception {
		
		type("TPenterRefNum_XPATH", refNum);
		CashPayment.getRefNum(OR.getProperty("TPverifybtn_XPATH"));
		click("TPverifybtn_XPATH");
		click("TPpaynow_XPATH");
		Thread.sleep(3000);
		
	}
}
