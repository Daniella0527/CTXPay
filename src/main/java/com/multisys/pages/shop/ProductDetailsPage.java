package com.multisys.pages.shop;

import org.openqa.selenium.JavascriptExecutor;

import com.multisys.base.Page;

public class ProductDetailsPage extends Page {
	
public void EnterQuantity(String quantity){
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,300)");
	 type("PRquantity_XPATH", quantity);
}

/*public void EnterQuantity(){
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,300)");
	type("PRquantity_XPATH", "2");
}*/

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