package com.multisys.pages.checkout;

import com.multisys.base.Page;

public class CheckoutPage extends Page {


	public void EnterBillingAddress(String firstname ,String lastname, String companyname, String country, String streetaddress, String streetaddressl2, String city, String region, String postcode, String phonenum, String emailadd, String ordernotes) {
		type("CHfname_XPATH",firstname);
		type("CHlname_XPATH", lastname);
		type("CHcompany_XPATH", companyname);
		select("CHcountry_ID", country);
		type("CHaddressl1_XPATH", streetaddress);
		type("CHaddressl2_XPATH", streetaddressl2);
		type("CHcity_XPATH", city);
		select("CHregion_ID", region);
		type("CHpostalcode_XPATH", postcode);
		type("CHphonenum_XPATH", phonenum);
		type("CHemail_XPATH", emailadd);	
		type("CHaddinfo_XPATH", ordernotes);
	}
	
	
	public void placeOrder() {
	click ("CHplaceorderbtn_XPATH");
	}
}
