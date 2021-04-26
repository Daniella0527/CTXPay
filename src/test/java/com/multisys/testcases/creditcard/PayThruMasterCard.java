package com.multisys.testcases.creditcard;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.multisys.pages.checkout.CTXPayPage;
import com.multisys.pages.checkout.CreditCard;
import com.multisys.utilities.Utilities;

public class PayThruMasterCard {

		@Test(dataProviderClass = Utilities.class, dataProvider = "dp")
		public void payThruMasterCard(Hashtable<String, String> data) throws InterruptedException {
			Thread.sleep(10000);
			CTXPayPage ctx = new CTXPayPage();
			CreditCard card = ctx.creditCardPayment();
			card.enterCardDetails(data.get("Card Number"), data.get("Card Holder's Name"), data.get("Expiry Date"),
					data.get("CVV"));
			card.paynow();

		}

	}