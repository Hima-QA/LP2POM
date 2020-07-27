package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.base.BasePage;
import com.qa.crm.acc.pages.AccountPage;
import com.qa.crm.acc.pages.ConfirmImpAccMappingPage;
import com.qa.crm.acc.pages.ConfirmImportAccPage;
import com.qa.crm.acc.pages.CreateAccountPage;
import com.qa.crm.acc.pages.ImportAccountPage;
import com.qa.crm.acc.pages.ImportFinishPage;
import com.qa.crm.acc.pages.SavedAccountPage;

public class ImportAccountTest {
	@Test
	public void importAccountTest() {
		
	
		AccountPage accPg = new AccountPage();
		accPg = BasePage.tmenu.gotoAccounts();
		ImportAccountPage iap = accPg.gotoImportAccount();	
		System.out.println("Now to import");
		//ImportAccountPage iap = new ImportAccountPage();
		ConfirmImportAccPage cip = iap.importAccount("C:\\Users\\ADMIN\\Downloads\\SampleCsvFile.csv");
		System.out.println("File added");
		
		
		ConfirmImpAccMappingPage map = cip.confirmImport();
		ImportFinishPage ifp = map.confirmImportMapping();
		ifp.importFinish();
		
	}

}
