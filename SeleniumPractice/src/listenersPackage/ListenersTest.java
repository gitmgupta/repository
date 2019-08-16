package listenersPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenersTest extends TestListenerAdapter implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFinish(ITestResult testContext) {
		System.out.println("Test Finish");

	}

	public void onTestFailure(ITestResult testResult) {
		System.out.println("Test Failed");
		System.out.println("The name of the testcase failed is :" + testResult.getName());

	}

	public void onTestSkipped(ITestResult testResult) {
		System.out.println("Test Skipped");
		System.out.println("The name of the testcase Skipped is :" + testResult.getName());

	}

	public void onTestSuccess(ITestResult testResult) {
		System.out.println("The name of the testcase passed is :" + testResult.getName());

	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " test case started");

	}

}
