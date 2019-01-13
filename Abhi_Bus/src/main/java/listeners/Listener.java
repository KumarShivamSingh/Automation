//listener class for taking screenshots on any failure
package listeners;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import BaseTest.basePage;
public class Listener extends basePage  implements ITestListener{

	public void onFinish(ITestContext arg0) {
			
	}
	public void onStart(ITestContext arg0) {
			
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {	
	}
	public void onTestFailure(ITestResult arg0) {
		Reporter.log("Test was Failed" +arg0.getMethod().getMethodName());
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String MethodName=arg0.getName();
		
		    if(!(arg0.isSuccess()))
		    {
		    File sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   String reportDirectory = (new File(System.getProperty("user.dir")).getAbsolutePath() 
				   +"/src/main/java/");
		   File targetPath = new File((String)reportDirectory+"/failedScreens/"+MethodName+" "
		   		                                   +simpledate.format(cal.getTime())+".png");	   
				
		   try {
		   FileUtils.copyFile(sourcePath,targetPath);
		    }catch(IOException e) {   
		    	e.printStackTrace();
		    	
		    }
		   Reporter.log("<a href=' "+targetPath.getAbsolutePath()+" '>" +"<img src=' " 
                   +targetPath.getAbsolutePath()+" 'height='100' width='100'/></a>");
		   }
		
	}

	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("Test is Skipped" +arg0.getMethod().getMethodName());
		
	}

	public void onTestStart(ITestResult arg0) {
		Reporter.log("Test Start Running:   "   +arg0.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		   
	    }
	
}