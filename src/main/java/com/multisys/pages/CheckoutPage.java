package com.multisys.pages;

import com.multisys.base.Page;
import com.multisys.utilities.ExcelApiTest;

public class CheckoutPage extends Page {

	public void EnterBillingAddress() throws Exception {
		String sheetName = "BillingAddress";
		ExcelApiTest eat = new ExcelApiTest(path);

		type("CHfname_XPATH", eat.getCellData(sheetName, "First Name", 2));
		type("CHlname_XPATH", eat.getCellData(sheetName, "Last Name", 2));
		type("CHcompany_XPATH", eat.getCellData(sheetName, "Company Name", 2));
		select("CHcountry_ID", eat.getCellData(sheetName, "Country", 2));
		type("CHaddressl1_XPATH", eat.getCellData(sheetName, "House # & Street name", 2));
		type("CHaddressl2_XPATH", eat.getCellData(sheetName, "Barangay", 2));
		type("CHcity_XPATH", eat.getCellData(sheetName, "City", 2));
		select("CHregion_ID", eat.getCellData(sheetName, "Region", 2));
		type("CHpostalcode_XPATH", eat.getCellData(sheetName, "Postal Code", 2));
		type("CHphonenum_XPATH", eat.getCellData(sheetName, "Phone Number", 2));
		type("CHemail_XPATH", eat.getCellData(sheetName, "Email Address", 2));
		type("CHaddinfo_XPATH", eat.getCellData(sheetName, "Order Notes", 2));
	}

	public void placeOrder() {
		click("CHplaceorderbtn_XPATH");
	}
}
