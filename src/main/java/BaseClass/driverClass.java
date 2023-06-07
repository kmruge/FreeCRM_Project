package BaseClass;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;

import Util.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class driverClass {
	public static RemoteWebDriver driver;
	public ExtentSparkReporter reporthtml=null;
	public ExtentReports report=null;
	public ExtentTest test=null;
	@BeforeTest
	public void reportCreation()
	{
		reporthtml=new ExtentSparkReporter(new File("C:\\Users\\kmruge\\eclipse-workspace\\freecrm_project\\ExtentsReport\\extents.html"));
		reporthtml.config().setDocumentTitle("FreeCRM project");
		reporthtml.config().setReportName("Functional Report");
		reporthtml.config().setTheme(Theme.DARK);
		report=new ExtentReports();
		report.attachReporter(reporthtml);
		report.setSystemInfo("Window", "Windows10");
		report.setSystemInfo("Tester Name", "Muru");
		report.setSystemInfo("Id", "kmruge");
	}
	@AfterTest
	public void flush()
	{
		report.flush();
	}
	
	@Parameters("browser")
	@BeforeMethod
    public void driverInsta(String bro, Method testMethod)
	{
		WebDriverManager.chromedriver().setup();
		test=report.createTest(testMethod.getName());
		browserSelect(bro);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(Constants.URL);
	}
	@AfterMethod
	public void afterTestRun(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "Test failed at "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test Passed at "+result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
	        test.log(Status.SKIP, "Test result Skipped at "+result.getName());
		}
	}
	private void browserSelect(String bro) {
		if(bro.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(bro.equals("fireFox"))
		{
			driver=new FirefoxDriver();
		}
		else if(bro.equals("edge"))
		{
			driver=new EdgeDriver();
		}
	}
}
