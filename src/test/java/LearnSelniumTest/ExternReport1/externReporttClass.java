package LearnSelniumTest.ExternReport1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class externReporttClass {

	ExtentReports report1;

	@Test
	public void externreport() {
		ExtentTest test = report1.createTest("Initialize Demo");
		System.setProperty("webdriver.chrome.driver", "/D:/Automation/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.getTitle());
		// test.addScreenCaptureFromBase64String(null);//It will take screenshot
		test.fail("result do not match");// it will fail the case
		report1.flush();// end of the test case we need write flush method in order to create report.

	}

	// ExternReport,ExternSparkReporters two classes are very mch important
	@BeforeTest
	public void externreportConfig() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";// this will give project path
																				// dymanically
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("AutomationTestReport");// This step will set up the reportName
		report.config().setDocumentTitle("Test Results");// set document title

		report1 = new ExtentReports();// Making ExtentReports report1 object global level in order to access in the Test class Method.
		report1.attachReporter(report);// we are attaching the sub class ExtentSparkReporter into the main class report
		report1.setSystemInfo("Tester", "naresh.murugan");
	}
}
