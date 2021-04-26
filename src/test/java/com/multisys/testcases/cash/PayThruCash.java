package com.multisys.testcases.cash;

import org.testng.annotations.Test;

import com.multisys.pages.checkout.CTXPayPage;

public class PayThruCash {
	@Test
	public void payThruCash() throws InterruptedException {
		CTXPayPage ctx = new CTXPayPage();
		ctx.cashPayment();
	}

	
}
