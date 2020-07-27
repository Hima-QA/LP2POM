package com.qa.crm.acc.pages;



//import org.openqa.selenium.By;

import com.qa.base.BasePage;

public class AccountPage extends BasePage{
	
	public CreateAccountPage gotoCreateAccount() {
		
	//Click on + button to create 
	//driver.findElement(By.xpath("//button[@class='customPlusBtn cP']")).click();
		
		click("createAccBtn_XPATH");
		return new CreateAccountPage();
	}
	
	public ImportAccountPage gotoImportAccount() {
	//Click on Import
	//driver.findElement(By.xpath("//lyte-yield[text()='Import']")).click();
		
		click("importAccBtn_ID");
		click("dropdownImpAccounts_XPATH");
		//select("importAccBtn_ID","Import Accounts");
		
		return new ImportAccountPage();
	}

}
