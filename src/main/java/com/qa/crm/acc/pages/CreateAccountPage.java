package com.qa.crm.acc.pages;

import org.openqa.selenium.By;

import com.qa.base.BasePage;

public class CreateAccountPage extends BasePage {

	public void createAccount(String accName) {
		
		//driver.findElement(By.id("Crm_Accounts_ACCOUNTNAME")).sendKeys(accName);
		type("accName_ID",accName);
	}
}
