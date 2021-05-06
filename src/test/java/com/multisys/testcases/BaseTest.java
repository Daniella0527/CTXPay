package com.multisys.testcases;

import org.testng.SkipException;
import org.testng.annotations.AfterSuite;
import com.multisys.base.Page;
import com.multisys.utilities.Utilities;


public class BaseTest extends Page{
	
	
	@AfterSuite
	public void tearDown() throws InterruptedException{
if (!Utilities.isTestRunnable("BaseTest", excel)) {
			throw new SkipException("Skipping the test " + "BaseTest" + " as the Run mode is NO");
		}
		
		Page.quit();
		
	}
	

}
