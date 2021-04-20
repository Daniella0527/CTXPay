package com.multisys.pages.checkout;

import com.multisys.base.Page;

public class CTXPayPage extends Page {

public void CashPayment(){
		
		click("CTXcashpayments_XPATH");
	
}

public void proceedPayment(){
	
	click("CTXproceedbtn_XPATH");
}

public void slctOtherPM(){
	
	click("CTXbackbtn_XPATH");
}
}
