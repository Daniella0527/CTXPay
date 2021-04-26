package com.multisys.testcases.ewallets;

import org.testng.annotations.Test;

import com.multisys.pages.checkout.CTXPayPage;
import com.multisys.pages.ewallets.Ewallets;

public class PayThruGrabPay {
	
@Test
	public void payThruGrabPay() {
		
		CTXPayPage ctx = new CTXPayPage();
		Ewallets e = ctx.ewalletsPayment();
		e.grabPay();
		
	}
}
