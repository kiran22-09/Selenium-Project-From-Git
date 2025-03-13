package tests;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	 @DataProvider(name = "getTestData")
	    public Object[][] dataSupplier() {
	        return new Object[][] {
	            {"amotooricap3@gmail.com", "12345"},
	            {"amotooricap3@gmail.com", "12435"}
	        };
	 }

}
