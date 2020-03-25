package com.Opencart.pagesobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CurrencyPage {
	WebDriver driver;
	By currdrop=By.xpath("//*[@id=\"form-currency\"]/div/button/span");
	By nam=By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button");
	public CurrencyPage()
	{
		this.driver=driver;
	}
	public void launbrow(String browser)
	{try
	
	{
		if(browser.equalsIgnoreCase("chrome"))//to launch chrome browser
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\CTS\\openacartbykiruba\\src\\test\\resources\\Driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))//to launch firefox browser
		{
			System.setProperty("webdriver.gecko.driver","src/test/resources/Driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();//maximize the window
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);//wait for desired time
		
	}
	
	catch(WebDriverException e)
	{//gets executed if above conditions fail
		System.out.println("Browser could not be launched");
	}
	}
	public void opencart_pg()
	{
		driver.get("https://demo.opencart.com/");
		System.out.println(driver.getTitle());
	}
	public void choose_currency() throws InterruptedException
	{
		driver.findElement(currdrop).click();//click currency
		driver.findElement(nam).click(); //click desired currency
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");//scroll till desired currency is displayed
		 Thread.sleep(3000);
		 String s=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div[2]/p[2]")).getText();//get currency name
		 System.out.println(s);//print the currency name
	}
	public void close_site()
	{
		driver.close();//close the browser
	}
}
