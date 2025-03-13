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

public class TstNG_dataProviderUsingMethods {
    WebDriver driver;
    WebDriverWait wait;
    
    @BeforeMethod
    public void setup() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();  // Assigning to the global 'driver' variable
        driver.manage().window().maximize();
        driver.get("https://tutorialsninja.com/demo/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }// Initialize wait
    

    @Test(dataProvider = "dataSupplier")
    public void VerifyLogin(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Login'])[1]"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-password"))).sendKeys(password);
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='btn btn-primary']"))).click();
        
        // Assertion
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Edit your account information']"))).isDisplayed());
    }
    
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(parallel = true)
    public Object[][] dataSupplier() {
        return new Object[][] {
            {"amotooricap3@gmail.com", "12345"},
            {"amotooricap3@gmail.com", "12345"}
        };
    }
}
