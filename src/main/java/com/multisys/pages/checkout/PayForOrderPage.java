package com.multisys.pages.checkout;

import com.multisys.base.Page;

public class PayForOrderPage extends Page {

public CTXPayPage paynow(){
		
		click("PFOpaynowbtn_XPATH");
		return new CTXPayPage();
}

public void cancelorder(){
	
	click("PFOcancelorderbtn_XPATH");
}	

}