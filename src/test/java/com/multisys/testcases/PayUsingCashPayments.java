package com.multisys.testcases;

import org.testng.annotations.Test;

import com.multisys.pages.checkout.CTXPayPage;
import com.multisys.pages.checkout.PayForOrderPage;

public class PayUsingCashPayments {
	
	@Test
	public void payUsingCashPayments(){
		
		PayForOrderPage pfo = new PayForOrderPage();
		CTXPayPage ctx = pfo.paynow();
		ctx.CashPayment();
		ctx.proceedPayment();
		
	}
}
