package tests;

import org.testng.annotations.Test;

public class Register {
	
	@Test(priority=1)
	public void registerwithMandatoryfield() {
		System.out.println("registerwithMandatoryfield");
	}
	
	@Test(priority=2)
	public void registerwithallfield() {
		System.out.println("registerwithallfield");
	}
	
	@Test(priority=3)
	public void registerwithoutProvodingAnyfield() {
		System.out.println("registerwithoutProvodingAnyfield");
	}
	
	
	@Test(priority=4)
	public void registerwithDuplicateAccount() {
		System.out.println("registerwithDuplicateAccount");
	}


}
