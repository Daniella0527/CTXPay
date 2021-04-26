package com.multisys.pages.checkout;

import com.multisys.base.Page;
import com.multisys.pages.ewallets.Ewallets;

public class CTXPayPage extends Page {

	
public CreditCard creditCardPayment(){
		
		click("MPcreditCard_XPATH");
	return new CreditCard();
}

public Ewallets ewalletsPayment(){
	
	click("EPeWallets_XPATH");

	return new Ewallets();
}

public void cashPayment(){
	
	click("CPcashpayments_XPATH");
	click("CPproceedbtn_XPATH");

}

public void slctOtherPM(){
	
	click("CTXbackbtn_XPATH");

	
}
}
