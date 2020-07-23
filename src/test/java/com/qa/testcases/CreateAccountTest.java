package com.qa.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.crm.acc.pages.AccountPage;
import com.qa.crm.acc.pages.CreateAccountPage;
import com.qa.pages.ZohoAppPage;
import com.qa.utilities.MyUtilities;

public class CreateAccountTest {

	@Test(dataProviderClass=MyUtilities.class,dataProvider="dp")
	public void createAccountTest(Hashtable<String,String> data) {
		
		ZohoAppPage zap = new ZohoAppPage();
		zap.goToCRM();
		AccountPage accPg = BasePage.tmenu.gotoAccounts();
		CreateAccountPage ap = accPg.gotoCreateAccount();
		ap.createAccount(data.get("accountName"));
		ap.createAccount(data.get("accSite_ID"));
		Assert.fail("Purposefully failed  msg");

	}
}
