package com.orgHrm.AppActions;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

public class AppFunc
{
	WebDriver driver;
	String title;
	WebElement  objpim;
	Actions a;
	
	public void openApp(String url)
	{
		driver=new FirefoxDriver();
		driver.get(url);
	}
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	public void implicitwait()
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public void closeApp()
	{
		driver.close();
		Reporter.log("close the browser");
		driver.quit();
		Reporter.log("close the object");
	}
	
	public void login(String un,String pwd)
	{
		title=driver.getTitle();
		if (title.equals("OrangeHRM"))
		{
			Reporter.log("OrangeHRM Title is displayed");
		}
		
		WebElement objun=driver.findElement(By.id("txtUsername"));
		WebElement objpwd=driver.findElement(By.id("txtPassword"));
		WebElement objlogin=driver.findElement(By.id("btnLogin"));
		
		if (objun.isDisplayed() & objpwd.isDisplayed() & objlogin.isDisplayed())
		{
			Reporter.log("UserName,Password and Login btn are avalaible");
		}
						
		objun.clear();
		objun.sendKeys(un);
		
		objpwd.clear();
		objpwd.sendKeys(pwd);
		
		objlogin.click();
	}
	
	public void VerifyWeltext()
	{
		title=driver.getTitle();
		if (title.equals("OrangeHRM"))
		{
			Reporter.log("OrangeHRM Admin page is displayed");
			
		}
		
		String weltext=driver.findElement(By.id("welcome")).getText();
		
		if (weltext.equals("Welcome Sreekanth"))
		{
			Reporter.log("Welcome Sreekanth is displayed");
			
		}
	}
	
	public void logout()
	{
		driver.findElement(By.id("welcome")).click();
		driver.findElement(By.linkText("Logout")).click();
		
		title=driver.getTitle();
		if (title.equals("OrangeHRM"))
		{
			Reporter.log("Logout is completed and OrangeHRM Home page is displayed");
			
		}
	}
	
	public void empcreation(String FN,String LN) throws InterruptedException, IOException
	{
		//mousemoverAction
		objpim=driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']"));
		a=new Actions(driver);
		a.moveToElement(objpim).perform();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Add Employee")).click();
				
		//verify add emp page
				
		String emptext=driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/h1")).getText();
		System.out.println(emptext.equals("Add Employee")?"Add Employee page is displayed":"Add Employee page is not displayed");
				
								
		driver.findElement(By.id("firstName")).sendKeys(FN);
		driver.findElement(By.id("lastName")).sendKeys(LN);
		driver.findElement(By.id("photofile")).click();
		//Thread.sleep(4000);
		//AutoIt
		Runtime.getRuntime().exec("D:\\upload.exe");
		Thread.sleep(6000);
		driver.findElement(By.id("btnSave")).click();
		Thread.sleep(6000);
	}
	
	public void verifyEmpName(String LN) throws InterruptedException
	{
		//mousemoverAction
		objpim=driver.findElement(By.xpath("//*[@id='menu_pim_viewPimModule']"));
		a=new Actions(driver);
		a.moveToElement(objpim).perform();
		Thread.sleep(4000);
		driver.findElement(By.linkText("Employee List")).click();
				
		//working with Emp table(Web table)
		WebElement table=driver.findElement(By.id("resultTable"));
				
		List<WebElement> Robj=table.findElements(By.tagName("tr"));
				
		for (int i = 1; i < Robj.size(); i++)
		{
			String AVLN = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr["+i+"]/td[4]/a")).getText();
			if (AVLN.equals(LN)) 
			{
				Reporter.log(AVLN+" is displayed at "+i+" row");
				break;
			}
					
		}
	}
	
	
	
	
}
