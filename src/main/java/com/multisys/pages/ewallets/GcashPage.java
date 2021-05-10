package com.multisys.pages.ewallets;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;

import com.multisys.base.Page;
import com.multisys.utilities.ExcelApiTest;

public class GcashPage extends Page {

	public void enterNumber() throws Exception {
		String sheetName = "payThruGcash";
		ExcelApiTest eat = new ExcelApiTest(path);

		type("Gnumber_XPATH", eat.getCellData(sheetName, "Gcash Number", 2));
		click("Gnextbtn_XPATH");
	}

	public void enterOTP() throws Exception {
		//String sheetName = "payThruGcash";
		//ExcelApiTest eat = new ExcelApiTest(path);

		//type("GOTP_XPATH", eat.getCellData(sheetName, "OTP", 2));

		Robot robot = new Robot();
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_8);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_8);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_8);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_8);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_8);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_8);		

		click("Gnextbtn2_XPATH");
	}

	public void enterMPin() throws Exception {
		//String sheetName = "payThruGcash";
		//ExcelApiTest eat = new ExcelApiTest(path);
		
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_1);
		Thread.sleep(1000);

		// type("GMPin_XPATH", eat.getCellData(sheetName, "MPIN", 2));
		click("Gnextbtn3_XPATH");
	}

	public void payNow() throws Exception {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");

		click("Gpaynow_XPATH");
		Thread.sleep(3000);

	}

}
