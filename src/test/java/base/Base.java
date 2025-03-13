package base;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	
	public void takeScreenshot(WebDriver driver, String testName) {
		
		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destFile = System.getProperty("user.dir")+"\\Screenshots\\"+testName+generateTimeStamp()+".png";
		System.out.println("DestFile ---------------"+destFile);
		
		try {
			FileUtils.copyFile(SrcFile, new File(destFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public String generateTimeStamp() { 
		
		Date date = new Date();
		
		return date.toString().replace(" " , "_").replace(":", "_");
				
	}

}
