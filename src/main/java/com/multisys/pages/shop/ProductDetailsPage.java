package com.multisys.pages.shop;

import com.multisys.base.Page;

public class ProductDetailsPage extends Page {
	
public void EnterQuantity(String quantity){
		
		type("PRquantity_XPATH", quantity);
}

public void ViewProductDesc(){
	
	click("PRdesc_XPATH");

}

public void ViewProductInfo(){
	
	click("PRinfo_XPATH");

}

public void ViewProductReviews(){
	
	click("PRreviews_XPATH");

}

public void AddToCart(){
	
	click("PRaddtocart_XPATH");
}

public void ViewCart(){
	
	click("PRviewcart_XPATH");
}


}