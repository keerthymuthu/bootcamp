package webdriverinterface;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public abstract class Reporter{
	public static ExtentHtmlReporter extentHtmlReporter;
	public static ExtentReports extent;
	public ExtentTest testSuite, test;
	public String testCaseName, testDescription, nodes;
	
	public void startReport() {
		extentHtmlReporter=new ExtentHtmlReporter("./reports/result.html");
		extentHtmlReporter.setAppendExisting(true);
		extent=new ExtentReports();
		extent.attachReporter(extentHtmlReporter);
	}
	
	public ExtentTest startTestCase(String testCaseName, String testDescription) {
		testSuite = extent.createTest(testCaseName, testDescription);		
		return testSuite;
	}

	public ExtentTest startTestModule(String nodes) {
		test = testSuite.createNode(nodes);
		return test;
	}
	public abstract double takeSnap();
	public void captureStep(String desc,String status) {
		MediaEntityModelProvider img = null;
		double fileName=takeSnap();
		try {
			img = MediaEntityBuilder.createScreenCaptureFromPath
					("./../reports/images/"+fileName+".png").build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(status.equalsIgnoreCase("PASS")) {
			test.pass(desc, img);		
		}else if(status.equalsIgnoreCase("FAIL")) {
			test.fail(desc, img);
			throw new RuntimeException();
		}
	}
 
	public void endResult() {
		extent.flush();
	}
}
