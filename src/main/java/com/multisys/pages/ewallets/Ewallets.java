package com.multisys.pages.ewallets;

import com.multisys.base.Page;

public class Ewallets extends Page {

	
	public GcashPage gcash() {
		click("EPgcash_XPATH");
		click("EPproceedbtn_XPATH");
		return new GcashPage();
		
	}
	
	public void aliPay() {
		click("EPaliPay_XPATH");
		click("EPproceedbtn_XPATH");
		
	}
	
	public void allEasy() {
		click("EPaliPay_XPATH");
		click("EPproceedbtn_XPATH");
		
	}
	
	public void weChatPay() {
		click("EPweChatPay_XPATH");
		click("EPproceedbtn_XPATH");
		
	}
	
	public void coinsPH() {
		click("EPcoinsPH_XPATH");
		click("EPproceedbtn_XPATH");
		
	}
	
	public void unionPay() {
		click("EPunionPay_XPATH");
		click("EPproceedbtn_XPATH");
		
	}
	
	public void grabPay() {
		click("EPgrabPay_XPATH");
		click("EPproceedbtn_XPATH");
		
	}
	
	
	
}
