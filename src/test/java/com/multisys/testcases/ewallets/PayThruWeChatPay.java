package com.multisys.testcases.ewallets;

import org.testng.annotations.Test;

import com.multisys.pages.checkout.CTXPayPage;
import com.multisys.pages.ewallets.Ewallets;

public class PayThruWeChatPay {

	@Test
public void payThruWeChatPay() {
		
		CTXPayPage ctx = new CTXPayPage();
		Ewallets e = ctx.ewalletsPayment();
		e.weChatPay();
		
	}
}
