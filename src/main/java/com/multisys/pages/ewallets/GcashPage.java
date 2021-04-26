package com.multisys.pages.ewallets;

import com.multisys.base.Page;

public class GcashPage extends Page {
	
	public void enterNumber(String gcashnum) {
		type("Gnumber_XPATH", gcashnum);
		click ("Gnextbtn_XPATH");
	}

}
