package com.multisys.pages;

import org.openqa.selenium.JavascriptExecutor;

import com.multisys.base.Page;
import com.multisys.utilities.ExcelApiTest;

public class ProductDetailsPage extends Page {

	public void EnterQuantity() throws Exception {
		String sheetName = "OrderDetails";
		ExcelApiTest eat = new ExcelApiTest(path);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		type("PRquantity_XPATH", eat.getCellData(sheetName, "Quantity", 2));
	}

	public void ViewProductDesc() {

		click("PRdesc_XPATH");

	}

	public void ViewProductInfo() {

		click("PRinfo_XPATH");

	}

	public void ViewProductReviews() {

		click("PRreviews_XPATH");

	}

	public void AddToCart() {

		click("PRaddtocart_XPATH");
	}

	public void ViewCart() {

		click("PRviewcart_XPATH");
	}

}