package com.multisys.pages;

import com.multisys.base.Page;
import com.multisys.pages.ctxpay.CTXPayPage;

public class PayForOrderPage extends Page {

	public CTXPayPage paynow() {

		click("PFOpaynowbtn_XPATH");

		return new CTXPayPage();
	}

	public void cancelorder() {

		click("PFOcancelorderbtn_XPATH");
	}

}