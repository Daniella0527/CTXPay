package com.multisys.testcases.ewallets;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.multisys.pages.checkout.CTXPayPage;
import com.multisys.pages.ewallets.Ewallets;
import com.multisys.pages.ewallets.GcashPage;
import com.multisys.utilities.Utilities;

public class PayThruGcash {

	
@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
public void payThruGcash(Hashtable<String, String> data) {
		
		CTXPayPage ctx = new CTXPayPage();
		Ewallets e = ctx.ewalletsPayment();
		GcashPage gcash = e.gcash();
		gcash.enterNumber(data.get("Gcash Number"));
		
	}

	
	
	
}
