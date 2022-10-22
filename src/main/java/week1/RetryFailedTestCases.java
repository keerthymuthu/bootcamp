package week1;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;

public class RetryFailedTestCases implements IRetryAnalyzer,IAnnotationTransformer{

	int retryCount=0;
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if(!result.isSuccess() && retryCount<2) {
			System.out.println("In retry: "+retryCount);
			retryCount++;
			return true;
		}
		else
			return false;
	}
	
	public void transform(ITestAnnotation annotation,Class testClass, Constructor testConstructor,Method testMethod) {
			System.out.println("In transform");
			annotation.setRetryAnalyzer(this.getClass());
	}

}
