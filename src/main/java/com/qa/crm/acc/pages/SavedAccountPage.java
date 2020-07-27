package com.qa.crm.acc.pages;

import com.qa.base.BasePage;

public class SavedAccountPage extends BasePage{
	
	public AccountPage savedAccountPage() {
		
		
		click("backarrow_XPATH");
		return new AccountPage();
	}

}
