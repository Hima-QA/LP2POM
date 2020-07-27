package com.qa.crm.acc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.qa.base.BasePage;

public class ConfirmImpAccMappingPage extends BasePage {
	
	public ImportFinishPage confirmImportMapping() {
		
	//Click on nxt and accept the alert
		click("mapSubmitBtn_XPATH");
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("confirmMapBtn_XPATH"))),"ConfirmNext btn not present");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("confirmMapBtn_XPATH"))));
		click("confirmMapBtn_XPATH");
		 
		
		return new  ImportFinishPage();
		
	}

}
