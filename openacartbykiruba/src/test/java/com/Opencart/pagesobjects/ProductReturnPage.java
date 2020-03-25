package com.Opencart.pagesobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProductReturnPage {
	WebDriver driver;
	By returns=By.xpath("/html/body/footer/div/div/div[2]/ul/li[2]/a");
	By fname=By.id("input-firstname");
	By lname=By.id("input-lastname");
	By email=By.id("input-email");
	By telph=By.id("input-telephone");
	By orderid=By.id("input-order-id");
	By prodname=By.id("input-product");
	By model=By.id("input-model");
	By cbox=By.xpath("/html/body/div[2]/div/div/form/fieldset[2]/div[4]/div/div[2]/label/input");
	By chkbox=By.xpath("/html/body/div[2]/div/div/form/fieldset[2]/div[5]/div/label[2]/input");
	By sub=By.xpath("/html/body/div[2]/div/div/form/div/div[2]/input");
	By con=By.xpath("//*[@id=\"content\"]/div/div/a");
	public ProductReturnPage()
	{
		this.driver=driver;
	}
	public void launchthebrowser(String browser)
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
	public void opencart_pag()
	{
		driver.get("https://demo.opencart.com/");
		System.out.println(driver.getTitle());
	}
	public void product_return() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,2000)");//scroll till desired currency is displayed
		 Thread.sleep(3000);
		driver.findElement(returns).click();//click returns
		driver.findElement(fname).sendKeys("kirubakar");
		driver.findElement(lname).sendKeys("L");
		driver.findElement(email).sendKeys("kirubs1998@gmail.com");
		driver.findElement(telph).sendKeys("987654321");
		driver.findElement(orderid).sendKeys("12345");
		driver.findElement(prodname).sendKeys("MacBook");
		driver.findElement(model).sendKeys("56789");
		driver.findElement(cbox).click();
		driver.findElement(chkbox).click();
		driver.findElement(sub).click();
		driver.findElement(con).click();
		
	
		 
	}
	public void close_returnpage()
	{
		driver.close();//close the browser
	}
}

