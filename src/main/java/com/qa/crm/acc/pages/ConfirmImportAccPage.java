package com.qa.crm.acc.pages;

import com.qa.base.BasePage;

public class ConfirmImportAccPage extends BasePage {
	
	public ConfirmImpAccMappingPage confirmImport() {
		
		//Click on next again
		click("submitBtn_XPATH");
		
		return new ConfirmImpAccMappingPage();
	}

}
