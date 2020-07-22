package com.qa.testcases;

import org.testng.annotations.AfterSuite;

import com.qa.base.BasePage;


	//Anything common for all testcases
public class BaseTestCase {

	@AfterSuite
	public void tearDown() {
		
		//BasePage.quit();
	}
}
