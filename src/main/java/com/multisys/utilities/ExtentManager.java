package com.multisys.utilities;

import java.io.File;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {
	
	private static ExtentReports extent;
	
	
	public static ExtentReports getInstance(){
		
		if(extent==null){
			
			
			extent = new ExtentReports(System.getProperty("user.dir")+ File.separator + "target" + File.separator + "surefire-reports" + File.separator + "html" + File.separator + "extent.html",true,DisplayOrder.OLDEST_FIRST);
			extent.loadConfig(new File(System.getProperty("user.dir")+ File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "com" + File.separator + "multisys" + File.separator + "extentconfig" + File.separator + "ReportsConfig.xml"));
			
			
		}
		
		return extent;
		
	}

}