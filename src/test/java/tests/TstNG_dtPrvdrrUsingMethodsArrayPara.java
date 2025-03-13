package tests;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.Assert;

public class TstNG_dtPrvdrrUsingMethodsArrayPara {
    WebDriver driver;
    WebDriverWait wait;
    
    @BeforeMethod
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();  // Assigning to the global 'driver' variable
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Initialize wait
    }

    @Test(dataProvider = "getTestData", dataProviderClass = DataProviderClass.class)
    public void VerifyLogin(String[] str) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Login'])[1]"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).sendKeys(str[0]);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-password"))).sendKeys(str[1]);
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='btn btn-primary']"))).click();
        
        // Assertion
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Edit your account information']"))).isDisplayed());
    }
    
    @AfterMethod
    public void teardown() {
            driver.quit();
        
    }

   
    
}
