package com.orgHrm.TestScripts;

import org.testng.annotations.Test;

public class TC1 extends rootest
{

	@Test
	public void Adminlogin()
	{
		ap.openApp("http://orangehrm.uftselenium.com");
		ap.maximize();
		ap.implicitwait();
		ap.login("sreekanthsreekanth4", "sreekanth@123324");
		ap.VerifyWeltext();
		ap.logout();
		ap.closeApp();
	}
	
	
	
	
}
