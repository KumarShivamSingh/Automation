package BaseTest;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class basePage {
	public static WebDriver driver;
	public static final String path="./config.properties";
	public String log4jPath="log4j.properties";
	public static ExtentReports extent;
	public static ExtentTest test;
	public ITestResult result;
	//static block for reporting
	static
	{  
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat simpledate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		extent=new ExtentReports(System.getProperty("user.dir")+"/src/main/java/htmlReports/test-"
                +simpledate.format(cal.getTime())+".html",false);		
	}
	// Method to fetch data from config.properties
	public String getData(String key) throws Exception {
		File f=new File(path);
		FileInputStream fi=new FileInputStream(f);
		Properties p = new Properties();
		p.load(fi);
		return p.getProperty(key);
	}
	   //method to handle dropdowns
		public void selectOption(WebElement element, int option) {
			Select s=new Select(element);
			s.selectByIndex(option);
		}
		public void elementVisible(int time,WebElement element) {
			WebDriverWait wait=new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
		}	
		//Method for selecting dates from calender
		public static void datePicker(WebDriver driver, WebElement element, String dateval)
		{
			String date=dateval;
			String[] temp=date.split("/");
			String dt,month,year;
			dt=temp[0];
			month=temp[1];
			year=temp[2];
			String calyear,calmonth,caldt;
			element.click();
			WebElement table;
			table=driver.findElement(By.id("ui-datepicker-div"));
			List<WebElement> rows,cols;
			rows=driver.findElements(By.tagName("tr"));
			for (int i = 0; i <rows.size(); i++) 
			{   
				cols=driver.findElements(By.tagName("tr")).get(i).findElements(By.tagName("td"));
				for (int j = 0; j<cols.size(); j++) 
				{
					caldt=driver.findElements(By.tagName("tr")).get(i).findElements(By.tagName("td")).get(j).getText();
					if (caldt.equals(dt)) 
					{
						rows.get(i).findElements(By.tagName("td")).get(j).click();
						break;	
					}
					
				}
			}
		}
		//Method for launching browser
	public void browserLaunch(String browser, String url) {
	if (browser.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	} else if(browser.equalsIgnoreCase("firefox")) {
		driver=new FirefoxDriver();
	}
	     driver.get(url);
	     driver.manage().window().maximize();	
	     PropertyConfigurator.configure(log4jPath);
   }
	@BeforeMethod
		public void startReport(Method result) {
		test=extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName()+"Test is Started");						
		}			
	@AfterMethod
	public void endReport(ITestResult result) {
		getResult(result);
	}
	public void getResult(ITestResult result2) {
		if(result2.getStatus()==ITestResult.SUCCESS) {
			test.log(LogStatus.PASS,result2.getName()+ " Test is Success ");
		}
		else if(result2.getStatus()==ITestResult.FAILURE) {
			test.log(LogStatus.FAIL,result2.getName()+ " Test is Failed reason is: "+result2.getThrowable());
		}
		else if(result2.getStatus()==ITestResult.SKIP) {
			test.log(LogStatus.SKIP,result2.getName()+ " Test is Skipped reason is: "+result2.getThrowable());
		}
	}
	@AfterClass
	public void endTest() {
		closeBrowser();
	}
	public void closeBrowser() {
		driver.quit();
		extent.endTest(test);
		extent.flush();
		
	}
}



