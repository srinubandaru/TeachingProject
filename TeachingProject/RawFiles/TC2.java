package com.orgHrm.TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

public class TC2 extends rootest
{

	@Test
	public void EmpCreation() throws InterruptedException, IOException
	{
		ap.openApp("http://orangehrm.uftselenium.com");
		ap.maximize();
		ap.implicitwait();
		ap.login("sreekanthsreekanth4", "sreekanth@123324");
		ap.VerifyWeltext();
		
		ap.empcreation("abac", "abcd");
		ap.verifyEmpName("abcd");
				
		ap.logout();
		ap.closeApp();
	}
}
