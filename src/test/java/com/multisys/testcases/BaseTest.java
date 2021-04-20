package com.multisys.testcases;

import org.testng.annotations.AfterSuite;

import com.multisys.base.Page;

public class BaseTest {
	
	
	@AfterSuite
	public void tearDown(){
		
		Page.quit();
		
	}

}
