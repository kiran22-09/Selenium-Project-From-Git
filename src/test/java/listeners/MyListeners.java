package listeners;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;


public class MyListeners extends Base implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getName() + " started.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getName() + " passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getName() + " failed.");

        try {
            Object testInstance = result.getInstance();
            WebDriver driver = (WebDriver) testInstance.getClass().getDeclaredField("driver").get(testInstance);
            if (driver != null) {
                takeScreenshot(driver, result.getName());
            } else {
                System.out.println("WebDriver instance is null, cannot take screenshot.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getName() + " skipped.");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println(result.getName() + " failed due to timeout.");
    }
}
