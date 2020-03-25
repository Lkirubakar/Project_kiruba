package com.Opencart.pagesobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactUsPage {
	WebDriver driver;
	By contact=By.xpath("/html/body/footer/div/div/div[2]/ul/li[1]/a");
	By name=By.id("input-name");
	By email=By.id("input-email");
	By enquiry=By.id("input-enquiry");
	By button=By.xpath("//*[@id=\"content\"]/form/div/div/input");
	By cont=By.xpath("//*[@id=\"content\"]/div/div/a");
	public ContactUsPage()
	{
		this.driver=driver;
	}
	public void browsing(String browser)
	{
	try
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\CTS\\openacartbykiruba\\src\\test\\resources\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","src/test/resources/Driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	catch(WebDriverException e)
	{
		System.out.println("Browser could not be launched");
	}
	}
	public void opencart_pgcontact()
	{
		driver.get("https://demo.opencart.com/");
		System.out.println(driver.getTitle());
	}
	public void contactform() throws InterruptedException
	{	
		JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,3000)");
	 Thread.sleep(1000);
		driver.findElement(contact).click();//click contact
		driver.findElement(name).sendKeys("Admin");//get name from user
		driver.findElement(email).sendKeys("adminxxx@gmail.com");//get email id
		driver.findElement(enquiry).sendKeys("opencart is very good,simple and easy to use to order the products");//get enquiry detail
		driver.findElement(button).click();//click submit button
		Thread.sleep(3000);
		driver.findElement(cont).click();//click continue
	}
	public void closer()
	{
		driver.close();
	}
}
