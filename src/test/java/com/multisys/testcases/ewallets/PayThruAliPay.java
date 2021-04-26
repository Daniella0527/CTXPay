package com.multisys.testcases.ewallets;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.multisys.pages.checkout.CTXPayPage;
import com.multisys.pages.ewallets.Ewallets;
import com.multisys.pages.ewallets.GcashPage;

public class PayThruAliPay {
	
	@Test
public void payThruAliPay() {
		
		CTXPayPage ctx = new CTXPayPage();
		Ewallets e = ctx.ewalletsPayment();
		e.aliPay();
		
	}
}
