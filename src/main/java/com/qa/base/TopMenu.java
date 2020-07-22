package com.qa.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.crm.acc.pages.AccountPage;

public class TopMenu {

	WebDriver driver;
	public TopMenu(WebDriver driver) {
		
		this.driver= driver;
	}
	public void gotoHome() {

	}
	public void gotoLeads() {

	}
	public void gotoContacts() {

	}
	public AccountPage gotoAccounts() {

		//driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click();
		BasePage.click("accounts_XPATH");
		return new AccountPage();
	}
	public void gotoDeals() {

	}
	public void gotoActivities() {

	}
	public void gotoReports() {

	}
	public void gotoAnalytics() {

	}
	public void gotoProducts() {

	}
}
