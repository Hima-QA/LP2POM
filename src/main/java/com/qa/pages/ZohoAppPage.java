package com.qa.pages;

//import org.openqa.selenium.By;

import com.qa.base.BasePage;
import com.qa.crm.pages.CRMHomePage;

public class ZohoAppPage extends BasePage{

	

	public void goToBooks() {

		//driver.findElement(By.xpath("//div[contains(text(),'Books')]")).click();
		click("Books_XPATH");
	}

	public void goToCalendar() {

		//driver.findElement(By.xpath("//div[contains(text(),'Calendar')]")).click();
		click("Calendar_XPATH");

	}

	public void goToCampaign() {

		//driver.findElement(By.xpath("//div[contains(text(),'Campaign')]")).click();
		click("Campaign_XPATH");

	}
	public void goToCliq() {

		//driver.findElement(By.xpath("//div[contains(text(),'Cliq')]")).click();
		click("Cliq_XPATH");

	}
	public void goToConnect() {

		//driver.findElement(By.xpath("//div[contains(text(),'Connect')]")).click();
		click("Connect_XPATH");

	}

	public CRMHomePage goToCRM() {

		click("CRM_XPATH");
		return new CRMHomePage();
	}

	public void goToDesk() {

		//driver.findElement(By.xpath("//div[contains(text(),'Desk')]")).click();
	
		click("Desk_XPATH");
	}

	public void goToInvoice() {

		//driver.findElement(By.xpath("//div[contains(text(),'Invoice')]")).click();
		click("Invoice_XPATH");

	}
	public void goToMail() {

		//driver.findElement(By.xpath("//div[contains(text(),'Mail')]")).click();
		click("Mail_XPATH");

	}
	public void goToSheet() {

		//driver.findElement(By.xpath("//div[contains(text(),'Sheet')]")).click();
		click("Sheet_XPATH");

	}
	public void goToShow() {

		//driver.findElement(By.xpath("//div[contains(text(),'Show')]")).click();
		click("Show_XPATH");

	}
	public void goToWorkDrive() {

		//driver.findElement(By.xpath("//div[contains(text(),'Workdrive')]")).click();
		click("Workdrive_XPATH");

	}
	public void goToWriter() {

		//driver.findElement(By.xpath("//div[contains(text(),'Writer')]")).click();
		click("Writer_XPATH");

	}





}
