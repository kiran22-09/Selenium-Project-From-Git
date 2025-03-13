package tests;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginForScreenshot extends Base {

    public WebDriver driver;
    Base base = new Base(); // Create an instance of Base to use takeScreenshot()

    @BeforeMethod
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");        
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
    	
    	if(result.getStatus() == ITestResult.FAILURE) {
    	String testName = result.getName();
		System.out.println(testName+ "failed");
		takeScreenshot(driver,testName);
    	}
        driver.quit();
    }

    @Test(priority = 1)
    public void loginWithValidCredentials() {
        try {
            driver.findElement(By.xpath("//span[text()='My Account']")).click();
            driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();
            driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("amotooricap3@gmail.com");
            driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("12345");
            driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();

            Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Edit your account information']")).isDisplayed());
        }
        
        catch (Exception e) {
            base.takeScreenshot(driver, "loginWithValidCredentials_Failure");
            throw e; 
        }
    }   

    @Test(priority = 2)
    public void loginWithValidEmailAndInvalidPassword() {
        
            driver.findElement(By.xpath("//span[text()='My Account']")).click();
            driver.findElement(By.xpath("(//a[text()='Login'])[1]")).click();
            driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("amotooricap63@gmail.com");
            driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("98");
            driver.findElement(By.xpath("//input[@class='btn btn-primary']")).click();
            
            Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Warningdyhrtgrdf')]")).isDisplayed());

       
    }
}
