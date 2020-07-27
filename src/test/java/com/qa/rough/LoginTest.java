package com.qa.rough;

import com.qa.base.BasePage;
import com.qa.crm.acc.pages.AccountPage;
import com.qa.crm.acc.pages.CreateAccountPage;
import com.qa.crm.acc.pages.ImportAccountPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ZohoAppPage;


public class LoginTest {

	public static void main(String[] args) {
		/*
		HomePage home = new HomePage();
		home.goToLogin();
		LoginPage lp = new LoginPage();
		lp.doLogin("testtek789@gmail.com", "zoho@test123");
		ZohoAppPage zap = new ZohoAppPage();
		zap.goToCRM();
		BasePage.tmenu.gotoAccounts();
		AccountPage accPg = new AccountPage();
		accPg.gotoCreateAccount();
		CreateAccountPage cap = new CreateAccountPage();
		*/
	
		//code optimized
		//testing
		HomePage home = new HomePage();
		LoginPage lp = home.goToLogin();
		ZohoAppPage zap = lp.doLogin("testtek789@gmail.com", "zoho@test123");
		zap.goToCRM();
		AccountPage accPg = BasePage.tmenu.gotoAccounts();
		CreateAccountPage cAp = accPg.gotoCreateAccount();
		cAp.createAccount("Sima","vvgvgv");
		AccountPage accPg1 = BasePage.tmenu.gotoAccounts();
		
		ImportAccountPage iap = accPg1.gotoImportAccount();
	}

}
