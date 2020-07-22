package com.qa.extentListeners;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qa.base.BasePage;
import com.qa.utilities.MonitoringMail;
import com.qa.utilities.TestMailConfig;
//import com.relevantcodes.extentreports.LogStatus;




public class ExtentListeners extends BasePage implements ITestListener {

	public String messageBody;

	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";

	private static ExtentReports extent = ExtentManager.createInstance(System.getProperty("user.dir")+"\\reports\\"+fileName);
	
	public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	

	public void onTestStart(ITestResult result) {

	
		       
        test = extent.createTest(result.getTestClass().getName()+"     @TestCase : "+result.getMethod().getMethodName());
        testReport.set(test);
        

	}

	public void onTestSuccess(ITestResult result) {

		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " PASSED"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		testReport.get().pass(m);
		
		

	}

	public void onTestFailure(ITestResult result) {

	
		
		
		String excepionMessage=Arrays.toString(result.getThrowable().getStackTrace());
		testReport.get().fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
				+ "</font>" + "</b >" + "</summary>" +excepionMessage.replaceAll(",", "<br>")+"</details>"+" \n");
		
		//screenshot from extentmanager
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		try {

			ExtentManager.captureScreenshot();
			testReport.get().fail("<b>" + "<font color=" + "red>" + "Screenshot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.screenshotName)
							.build());
		} catch (IOException e) {

		}
		
		String failureLogg="TEST CASE FAILED";
		Markup m = MarkupHelper.createLabel(failureLogg, ExtentColor.RED);
		testReport.get().log(Status.FAIL, m);
		//testReport.get().log(Status.FAIL, result.getName().toUpperCase()+" TestCase failed here");

	}

	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"Test Case:- "+ methodName+ " Skipped"+"</b>";		
		Markup m=MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		testReport.get().skip(m);
		testReport.get().log(Status.SKIP, result.getName().toUpperCase()+" Skipped the testcase as the runmode is No");
		//test.log(Status.SKIP, result.getName().toUpperCase()+"Skipped the testcase as the runmode is No");


	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

		

	}

	public void onFinish(ITestContext context) {

		/*
		 * // Configuring to send mail after test suite MonitoringMail mail = new
		 * MonitoringMail(); try { messageBody = "http://" +
		 * InetAddress.getLocalHost().getHostAddress() +
		 * ":8080/job/LP2%20PageObjectModelBasics/Extent_20Report/"; } catch
		 * (UnknownHostException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } System.out.println(messageBody);
		 * 
		 * try { mail.sendMail(TestMailConfig.server, TestMailConfig.from,
		 * TestMailConfig.to, TestMailConfig.subject, messageBody); } catch
		 * (AddressException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); } catch (MessagingException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); }
		 */
		if (extent != null) {

			extent.flush();
		}

	}

}
