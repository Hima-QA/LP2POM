package com.qa.crm.acc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.qa.base.BasePage;

public class ImportAccountPage extends BasePage{
	
	public ConfirmImportAccPage importAccount(String filePath) {
		
		//Browse file and click on next
		type("browseBtn_XPATH",filePath);
		
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("upnextBtn_XPATH"))),"next btn not present");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("upnextBtn_XPATH"))));
		click("upnextBtn_XPATH");
		return new ConfirmImportAccPage();
		
	}

}
