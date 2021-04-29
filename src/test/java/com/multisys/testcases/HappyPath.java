package com.multisys.testcases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.multisys.base.Page;
import com.multisys.testcases.cash.PayThruCash;
import com.multisys.testcases.creditcard.PayThruVisa;
import com.multisys.testcases.ewallets.PayThruAliPay;
import com.multisys.testcases.ewallets.PayThruAllEasy;
import com.multisys.testcases.ewallets.PayThruGcash;
import com.multisys.utilities.Utilities;

public class HappyPath extends Page {

	@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
	public void orderDetails(Hashtable<String, String> data) throws Exception {
		if (!Utilities.isTestRunnable("HappyPath", excel)) {
			throw new SkipException("Skipping the test " + "HappyPath" + " as the Run mode is NO");
		}
		
		String pm = data.get("Payment Method");
		if (pm.equalsIgnoreCase("Cash")) {
			PayThruCash cash = new PayThruCash();
			cash.payThruCash(); 
		} else if (pm.equalsIgnoreCase("Credit Card")) {
				PayThruVisa visa =  new PayThruVisa();
				visa.payThruVisa();
				
		} else if (pm.equalsIgnoreCase("E-wallets")) {
			
			String wallet = data.get("E-Wallet");
			
			if (wallet.equalsIgnoreCase("Gcash")) {
				PayThruGcash gcash =  new PayThruGcash();
				gcash.payThruGcash();
			} else if (wallet.equalsIgnoreCase("AliPay")) {
				PayThruAliPay aliPay =  new PayThruAliPay();
				aliPay.payThruAliPay();
			} else if (wallet.equalsIgnoreCase("AllEasy")) {
				PayThruAllEasy allEasy =  new PayThruAllEasy();
				allEasy.payThruAllEasy();
			}
		}
		
	}

}

