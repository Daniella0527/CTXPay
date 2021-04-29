package com.multisys.testcases;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.multisys.base.Page;


public class BaseTest {
	
	
	@AfterSuite
	public void tearDown() throws InterruptedException{
		Page.quit();
		
	}
	

}
