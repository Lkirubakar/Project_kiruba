package com.Opencart.pagesobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrandsPage {
	WebDriver driver;
	By brand=By.xpath("/html/body/footer/div/div/div[3]/ul/li[1]/a");
	By manafacturer=By.xpath("//*[@id=\"content\"]/div[1]/div/a");
	By listview=By.xpath("//*[@id=\"list-view\"]");
	public BrandsPage()
	{
		this.driver=driver;
	}
	public void launchapp(String browser)
	{try
	{
		//to launch chrome browser
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))//to launch firefox browser
		{
			System.setProperty("webdriver.gecko.driver","src/test/resources/Driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();//maximize the window
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);//wait for specified time
		
	}
	
	catch(WebDriverException e)
	{//gets executed if above conditions fail
		System.out.println("Browser could not be launched");
	}
	}
	public void opencart_web()
	{
		driver.get("https://demo.opencart.com/");//get site
		System.out.println(driver.getTitle());//print site name
	}
	public void choose_brands() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");//scroll till desired item is got
		driver.findElement(brand).click();//click brands
		driver.findElement(manafacturer).click();//select desired brand
		driver.findElement(listview).click();//listview is enabled
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,3000)");//scroll till end
		Thread.sleep(3000);
		
	}
	public void close_the_browser()
	{
		driver.close();//close browser
	}
}
