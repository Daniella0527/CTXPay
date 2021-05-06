package com.multisys.base;

import java.io.File;

import com.multisys.utilities.ExcelApiTest;

public class Main extends Page{

	public static void main(String[] args) throws Exception {
		String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
				+ File.separator + "resources" + File.separator + "com" + File.separator + "multisys" + File.separator
				+ "excel" + File.separator + "testdata.xlsx";
		
		
		String sheetName = "payThruGcash";
	    ExcelApiTest eat = new ExcelApiTest(path);
		
		System.out.print(eat.getCellData(sheetName, "OTP", 2));
		click ("Gnextbtn3_XPATH");

	}

}
