package utils;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import org.openqa.selenium.WebDriver;
//import testBase.BaseClass;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
//import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class ExtentReportManager implements ITestListener {

    private static ExtentReports extent;
    private static ExtentSparkReporter sparkReporter;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String reportPath = "reports/ParabankReport_" + timestamp + ".html";

        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("Parabank Automation Report");
        sparkReporter.config().setReportName("Parabank Test Execution Report");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // System/environment info
        extent.setSystemInfo("Application", "Parabank");
        extent.setSystemInfo("Tester", "Ganesh U");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Browser", "Chrome");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test Passed");
        
        captureScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());
        
        captureScreenshot(result);
        
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
    
    
    private void captureScreenshot(ITestResult result) {
    	 try {
    	        WebDriver driver = ((testBase.BaseClass) result.getInstance()).getDriver();

    	        if (driver != null) {
    	            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    	          String screenshotPath = "screenshots/" + result.getMethod().getMethodName() + "_" + timestamp + ".png";
    	           // String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + result.getMethod().getMethodName() + "_" + timestamp + ".png";
    	           // test.get().addScreenCaptureFromPath(screenshotPath);

    	            try {
    	                File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    	                File destFile = new File(screenshotPath);
    	                FileUtils.copyFile(srcFile, destFile);

    	                test.get().addScreenCaptureFromPath(screenshotPath, "Screenshot");
    	            } catch (org.openqa.selenium.NoSuchSessionException e) {
    	                // Driver already quit, skip screenshot
    	                test.get().log(Status.WARNING, "WebDriver session is closed. Skipping screenshot.");
    	            }
    	        }
        } catch (Exception e) {
            e.printStackTrace();
            test.get().log(Status.WARNING, "Failed to capture screenshot: " + e.getMessage());
        }
    }
}
