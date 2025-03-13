package tests;

import org.testng.annotations.Test;

public class Login {
	
	
  @Test(priority =1)
  public void loginWithValidCredentials() {
	  System.out.println("LoginWithValidCredentials -----------LOGIN");	  
  }
  
  @Test(priority=2)
  public void loginWithValidEmailandInvalidPassword() {
	  System.out.println("loginWithValidEmailandInvalidPassword");  
  }
  
  @Test(priority=3)
  public void loginWithInValidEmailandvalidPassword() {
	  System.out.println("loginWithValidEmailandInvalidPassword");  
  }
  
  @Test(priority=4)
  public void loginWithInValidEmailandInvalidPassword() {
	  System.out.println("loginWithInValidEmailandInvalidPassword");
  }
  
  @Test(priority=5)
  public void loginWithoutProvidingCredentials() {
	  System.out.println("loginWithoutProvidingCredentials");
  }
  
  
}
