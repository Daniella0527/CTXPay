package com.multisys.pages;

import com.multisys.base.Page;

public class CartPage extends Page {

public void enterQuantity(String quantity){
		
		type("CAquantity_XPATH", quantity);
}


public void enterCouponCode(String code){
	
	type("CAcouponcode_XPATH", code);
}

public void applyCoupon(){
	
	click("CAcouponbtn");
}
public void updateCart(){
	
	click("CAupdatebtn");
}

public void proceedToCheckout(){
	
	click("CAcheckoutbtn_XPATH");
}

}
