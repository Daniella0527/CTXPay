package com.multisys.pages.ctxpay;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.multisys.base.Page;
import com.multisys.pages.ewallets.Ewallets;

public class CTXPayPage extends Page {

	public CreditCard creditCardPayment() {

		click("MPcreditCard_XPATH");
		return new CreditCard();
	}

	public Ewallets ewalletsPayment() {

		click("EPeWallets_XPATH");
		

		return new Ewallets();
	}

	public void cashPayment() {

		click("CPcashpayments_XPATH");
	
		//Assert.assertTrue(isElementPresent("CPproceedbtn_XPATH"));
		click("CPproceedbtn_XPATH");
		
		


	}

	public void slctOtherPM() {

		click("CTXbackbtn_XPATH");

	}
}
