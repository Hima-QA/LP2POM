package com.qa.crm.acc.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.qa.base.BasePage;

public class ImportFinishPage extends BasePage{
	
	public AccountPage importFinish() {
		
		click("importFinishBtn_XPATH");
		
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("okBtn_XPATH"))),"OK btn not present");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(or.getProperty("okBtn_XPATH"))));
		click("okBtn_XPATH");
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(or.getProperty("statusPopup_XPATH"))));
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("statusPopup_XPATH"))),"POPup not present");
		
		driver.navigate().refresh();
		System.out.println("Succesfully added csv");
		return new AccountPage();
		
	}

}
