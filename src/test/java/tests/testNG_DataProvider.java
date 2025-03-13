package tests;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class testNG_DataProvider {
	
  @Test(dataProvider = "dataSupplier")
  public void VerifyLogin(String username, String password) {
      WebDriverManager.edgedriver().setup();
      WebDriver driver = new EdgeDriver(); 
      driver.get("https://tutorialsninja.com/demo/");
      driver.manage().window().maximize();

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait

      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='My Account']"))).click();
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[text()='Login'])[1]"))).click();
      
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email"))).sendKeys(username);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-password"))).sendKeys(password);
      
      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='btn btn-primary']"))).click();
      
      // Assertion
      Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Edit your account information']"))).isDisplayed());

      driver.quit();
  }

  @DataProvider(parallel = true)
  public Object[][] dataSupplier() {
	  
	  Object [] []  data = { {"amotooricap3@gmail.com","12345"} , 
			  				 {"amotooricap3@gmail.com","12345"} , 
			  				 {"amotooricap3@gmail.com","12345"} , 
			  				 {"amotooricap3@gmail.com","12345"} , 
			  				 {"amotooricap3@gmail.com","12345"}};
	  
	  return data;
	  
    
  }
}
