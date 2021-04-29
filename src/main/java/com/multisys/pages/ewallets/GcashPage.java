package com.multisys.pages.ewallets;

import com.multisys.base.Page;
import com.multisys.utilities.ExcelApiTest;

public class GcashPage extends Page {
	
	public void enterNumber() throws Exception {
		String sheetName = "payThruGcash";
	    ExcelApiTest eat = new ExcelApiTest(path);
		
		type("Gnumber_XPATH", eat.getCellData(sheetName, "Gcash Number", 2));
		click ("Gnextbtn_XPATH");
	}

}
