package com.multisys.testcases.ewallets;

import org.testng.annotations.Test;

import com.multisys.pages.checkout.CTXPayPage;
import com.multisys.pages.ewallets.Ewallets;

public class PayThruUnionPay {
	
	@Test
public void payThruUnionPay() {
		
		CTXPayPage ctx = new CTXPayPage();
		Ewallets e = ctx.ewalletsPayment();
		e.unionPay();
		
	}
}
