package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.qa.extentListeners.ExtentManager;
//import com.qa.extentListeners.ExtentManager;
import com.qa.utilities.ExcelReader;
import com.qa.utilities.MyUtilities;
//import com.relevantcodes.extentreports.LogStatus;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static WebDriver driver;
	public static TopMenu tmenu;
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger(BasePage.class.getName()); 	//Logs
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\qa\\excel\\testdata.xlsx");	//Excel imported from utilities specify the path of excel
	public static WebDriverWait wait;
	//public static ExtentReports report = ExtentManager.getInstance();
	//public static ExtentTest  test;
	public static ExtentReports extent;
	public static ExtentTest  test;
	public static String browser;
	

	public BasePage() {

		if(driver==null) {

	//Configuring log4j.properties
			PropertyConfigurator.configure(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\qa\\properties\\log4j.properties");

	//Configuring Config.properties file
			try {
				fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\qa\\properties\\Config.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				config.load(fis);
				log.info("Config property file is loaded"); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	//Configuring OR.properties file
			try {
				fis =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\qa\\properties\\OR.properties");
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				or.load(fis);
				log.info("OR property file is loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	//Jenkins browser filter configurations
			if(System.getenv("browser")!=null && !System.getenv("browser").isEmpty()){

				browser = System.getenv("browser");
			}else{

				browser = config.getProperty("browser"); 
				//If nothing is taken from Jenkins it will take from cofig.property file

			}

			config.setProperty("browser", browser);


	//Note:Using WebDriverManager instead of Executables
			
			if (config.getProperty("browser").equals("firefox")) {

				// System.setProperty("webdriver.gecko.driver", "gecko.exe");
				
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.info("Firefox is Launched ");

			} else if (config.getProperty("browser").equals("chrome")) {

				/*System.setProperty("webdriver.chrome.driver",
							System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe"); */	
				

				WebDriverManager.chromedriver().setup();
				//setting chrome-options to disable pop-ups,disable-extensions,,disable-infobars
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled",false);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
				options.setExperimentalOption("useAutomationExtension", false);
				options.addArguments("--disable-extensions");
				options.addArguments("--disable-infobars");

				driver = new ChromeDriver(options);
				log.info("Chrome is Launched ");
				
			}else if (config.getProperty("browser").equals("ie")) {

				/*System.setProperty("webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");*/
				
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				log.info("IE is Launched ");

			}else if (config.getProperty("browser").equals("edge")) {

				/*System.setProperty("webdriver.edge.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");*/
				
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				log.info("Edge is Launched ");

			} 
		

			//Getting the site URL stored in config.property file
			driver.get(config.getProperty("testsiteurl"));		
			log.info("Navigated to:" +config.getProperty("testsiteurl"));
			driver.manage().window().maximize();	
			//Adding implicit wait set in config.property file
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
			
			//Adding explicit wait
			wait = new WebDriverWait(driver,5);
			tmenu = new TopMenu(driver);
			

		}
	}
	
	//driver  quit
	public static void quit() {
		driver.quit();
	}
	
	
	//Checking if ElementPresent or not
		public boolean isElementPresent(By by) {

			try {

				driver.findElement(by);
				return true;

			} catch (NoSuchElementException e) {
				log.error("Element not found");

				return false;

			}
		}	
		
		//Clicking on Locator
		public static void click(String locator) {
			
			if (locator.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(or.getProperty(locator))).click();
			} else if (locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(or.getProperty(locator))).click();
			} else if (locator.endsWith("_ID")) {
				driver.findElement(By.id(or.getProperty(locator))).click();
			}
			
			log.info("Clicking on : " + locator);
			test.log(Status.INFO, "Clicking on : " + locator);

		}
		
		//Typing  in Locators and sending values
		public static void type(String locator, String value) {
			
			if (locator.endsWith("_CSS")) {
				driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_XPATH")) {
				driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
			} else if (locator.endsWith("_ID")) {
				driver.findElement(By.id(or.getProperty(locator))).sendKeys(value);
			}
			log.info("Typing in an element : " +locator+" entered value as " + value);
			
			test.log(Status.INFO, "Typing in : " + locator +" entered value as " + value);

		}
		
		
		//Try to capture img at every failure by verifying actual vs expected
		//This method can be used when a failure occurs and still the test case continue and report the failure
		public static void verifyEquals(String expected, String actual) throws IOException {

			try {

				Assert.assertEquals(actual, expected);

			} catch (Throwable t) {

				MyUtilities.captureScreenshot();
				// ReportNG
				Reporter.log("<br>" + "Verification failure : " + t.getMessage() + "<br>");
				Reporter.log("<a target=\"_blank\" href=" + MyUtilities.screenshotName + "><img src=" + MyUtilities.screenshotName
						+ " height=200 width=200></img></a>");
				Reporter.log("<br>");
				Reporter.log("<br>");
				
				// Extent Reports
				test.log(Status.FAIL, " Verification failed with exception : " + t.getMessage());
				test.log(Status.FAIL, (Markup) test.addScreenCaptureFromPath(MyUtilities.screenshotName));

			}

		}

		static WebElement dropdown;

		public static void select(String locator, String value) {

			if (locator.endsWith("_CSS")) {
				dropdown = driver.findElement(By.cssSelector(or.getProperty(locator)));
			} else if (locator.endsWith("_XPATH")) {
				dropdown = driver.findElement(By.xpath(or.getProperty(locator)));
			} else if (locator.endsWith("_ID")) {
				dropdown = driver.findElement(By.id(or.getProperty(locator)));
			}
			
			Select select = new Select(dropdown);
			select.selectByVisibleText(value);

			log.info("Selecting from dropdown : " + locator + " value as " + value);
			test.log(Status.INFO, "Selecting from dropdown : " + locator + " value as " + value);

		}

}
