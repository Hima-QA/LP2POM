package com.qa.pages;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;

import com.qa.base.BasePage;

public class HomePage extends BasePage{
	
	
	
	public void goToSignUp() {
	
		//driver.findElement(By.xpath("//a[@class='zh-signup']")).click();
		click("signupLink_XPATH");

	}

	public LoginPage goToLogin() {
		
		//driver.findElement(By.xpath("//a[@class='zh-login']")).click();
		
		click("loginLink_XPATH");
		return new LoginPage();
	}
	
	public void goToCustomers() {
		//driver.findElement(By.xpath("//a[@class='zh-customers']")).click();
		click("customersLink_XPATH");
	}
	
	public void goToSupport() {
		
		//driver.findElement(By.xpath("//a[@class='zh-support']")).click();
		click("supportLink_XPATH");

	}
	
	/*
	 * public void validateFooterLinks() {
	 * 
	 * }
	 */}
