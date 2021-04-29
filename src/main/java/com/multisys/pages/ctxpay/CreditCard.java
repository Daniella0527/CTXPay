package com.multisys.pages.ctxpay;


import com.multisys.base.Page;
import com.multisys.utilities.ExcelApiTest;

public class CreditCard extends Page {

	public void enterCardDetails() throws Exception {
	    Thread.sleep(5000);
	    
	    String sheetName = "payThruVisa";
	    ExcelApiTest eat = new ExcelApiTest(path);
		
		click("MPcardNum_XPATH");
		type("MPcardNum_XPATH", eat.getCellData(sheetName, "Card Number", 2));
		type("MPname_XPATH", eat.getCellData(sheetName, "Card Holder's Name", 2));
		click("MPexpiDate_XPATH");
		type("MPexpiDate_XPATH", eat.getCellData(sheetName, "Expiry Date", 2));
		type("MPcvv_XPATH", eat.getCellData(sheetName, "CVV", 2));
		click("MPcheckoutbtn_XPATH");
	}
	
	public void paynow() {
		
		click("MPpaynowbtn_XPATH");
	}
	
	
}
