package com.inetbanking.utilities;

// listener class used to generate extent reports
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext) {
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.hh.mm.ss").format(new Date());
		String repName = "Test-Report-"+timeStamp+".html";
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		//sparkReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("users", "tester");
		
		sparkReporter.config().setDocumentTitle("INetBanking Test Project");
		sparkReporter.config().setReportName("Functional Test Automation Report");
		sparkReporter.config().setTheme(Theme.DARK);	
	}
	
	public void onTestSuccess(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotPath = System.getProperty("user.dir")+"\\screenshots\\"+tr.getName()+".png";
		
		File file = new File(screenshotPath);
		
		if(file.exists()) {
			logger.fail("Screenshot is below:" +logger.addScreenCaptureFromPath(screenshotPath));			
		}
			
		}
	public void onTestSkipped(ITestResult tr) {
		logger = extent.createTest(tr.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}
	}

