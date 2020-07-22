package com.qa.pages;

//import org.openqa.selenium.By;

import com.qa.base.BasePage;
//import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {


	public ZohoAppPage doLogin(String username,String password) {
		
		type("emailLogin_XPATH",username);		
		click("nextBtn_XPATH");
		type("password_XPATH",password);
		click("signinBtn_XPATH");
		
		return new ZohoAppPage();
	}
	
	public void forgotPwd(String username) {
		
		
	}
}
