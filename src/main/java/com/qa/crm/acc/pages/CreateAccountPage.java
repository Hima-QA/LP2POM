package com.qa.crm.acc.pages;


//import org.openqa.selenium.By;

import com.qa.base.BasePage;

public class CreateAccountPage extends BasePage {

	public CreateAccountPage createAccount(String accName, String accSite) {
	
	
		//driver.findElement(By.id("Crm_Accounts_ACCOUNTNAME")).sendKeys(accName);
		
		 type("accName_ID",accName); 
		 type("accSite_ID",accSite);
		 click("saveBtn_ID");
		 	
		 return new CreateAccountPage();
	
	}
}
