package com.multisys.pages.checkout;


import com.multisys.base.Page;

public class CreditCard extends Page {

	public void enterCardDetails(String cardnum, String name, String expidate, String cvv) throws InterruptedException {
	    Thread.sleep(5000);
		
		click("MPcardNum_XPATH");
		type("MPcardNum_XPATH", cardnum);
		type("MPname_XPATH", name);
		click("MPexpiDate_XPATH");
		type("MPexpiDate_XPATH", expidate);
		type("MPcvv_XPATH", cvv);
		click("MPcheckoutbtn_XPATH");
	}
	
	public void paynow() {
		
		click("MPpaynowbtn_XPATH");
	}
	
	
}
