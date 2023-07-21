package listener;
import org.testng.ITestContext;		
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;	

public class Listener implements ITestListener{
	
	public void onFisnish(ITestContext result) {
		
	}
	
	public void onStart(ITestContext result) {
		
	}
	
	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)	{
		
	}
	
	public void onTestFailure(ITestResult Result){		
		System.out.println("The name of the testcase Failed is :"+Result.getName());					
    }	
	
	public void onTestSkipped(ITestResult Result){		
	    System.out.println("The name of the testcase Skipped is :"+Result.getName());					
	}
	
	public void onTestStart(ITestResult Result){
		 System.out.println("Test case "+Result.getName()+" started");	
	}
	
	public void onTestSuccess(ITestResult Result){		
	    System.out.println("The name of the testcase passed is :"+Result.getName());					
	}		
}
