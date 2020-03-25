package com.Opencart.pagesobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage 
{
	WebDriver driver;
	By myaccount=By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
	By login=By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
	By email2=By.name("email");
	By password2=By.name("password");
	By login_submit=By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input");
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
	}


	public void url(String browser,String url) 
	{
		try
		{
			//to launch chrome browser 
			if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "src/test/resources/Driver/chromedriver.exe");
				driver=new ChromeDriver();
			}
			//to launch firefox browser
			else if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","src/test/resources/Driver/geckodriver.exe");
				driver=new FirefoxDriver();
			}
			
			driver.manage().window().maximize(); //maximize the window
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS); //code will wait for specified time before execution
			
		}
		
		catch(WebDriverException e)
		{
			//browser could not be launched and so this statement will be displayed
			System.out.println("Browser could not be launched");
		}
		
		driver.get(url); //get url from user

	}

	
	public void opencart_login()
	{
		driver.findElement(myaccount).click();//click my account
		driver.findElement(login).click();//select login
	}
	
	public void login_details(String emailid,String pass) throws InterruptedException
	{
		driver.findElement(email2).sendKeys(emailid);//get email id from user
		driver.findElement(password2).sendKeys(pass);//get password id from user
		driver.findElement(login_submit).click();//click submit button
		Thread.sleep(3000);
	}
	
	public void quit()
	{
		driver.close(); //close the browser
	}


}
