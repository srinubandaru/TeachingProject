package com.orgHrm.TestScripts;

import java.io.IOException;

import org.testng.annotations.Test;

import com.orgHrm.AppActions.AppFunc;
import com.orgHrm.Utilities.Constants;

public class TC1 extends rootest
{
	
	

	@Test
	public void Adminlogin()
	{
		//ap.openApp("http://orangehrm.uftselenium.com");
		ap.openApp(con.url);
		ap.maximize();
		ap.implicitwait();
		ap.login(con.UserName, con.Password);
		ap.VerifyWeltext();
		ap.logout();
		ap.closeApp();
	}
	
	
	
	
	
}
