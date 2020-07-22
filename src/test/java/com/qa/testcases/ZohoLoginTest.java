package com.qa.testcases;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ZohoAppPage;
import com.qa.utilities.MyUtilities;
//import com.qa.utilities.TestUtil;


public class ZohoLoginTest extends BaseTestCase{

	@Test(dataProviderClass=MyUtilities.class,dataProvider="dp")
	public void zohoLoginTest(Hashtable<String,String> data)  {

		HomePage home = new HomePage();
		LoginPage lp = home.goToLogin();
		
		if(!MyUtilities.isTestRunnable("zohoLoginTest", BasePage.excel)) {
			throw new SkipException("Skipping the testcase: "+"zohoLoginTest".toUpperCase()+" as the runmode is No");
		}
		lp.doLogin(data.get("username"), data.get("password"));
		//ZohoAppPage zap = lp.doLogin("testtek789@gmail.com", "zoho@test123");
		
		Assert.fail("Purposefully failed Login msg");
	}
	
}
