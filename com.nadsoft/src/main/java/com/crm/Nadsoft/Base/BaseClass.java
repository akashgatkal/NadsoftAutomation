package com.crm.Nadsoft.Base;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.crm.fileUtility.ReadFromPropertyFile;

public class BaseClass {

	
	public static WebDriver driver=null;
	
	@Parameters("browser")
	@BeforeClass
public void precondition() throws IOException {
	String browser = ReadFromPropertyFile.PropertyData("browser");
	String url = ReadFromPropertyFile.PropertyData("url");
	if(browser.equalsIgnoreCase("chrome")) {
        driver= new ChromeDriver();
  }
	else if (browser.equalsIgnoreCase("firefox")) {
		  driver=(WebDriver) new FirefoxDriver();	
	}
	else if (browser.equalsIgnoreCase("edge")) {
		 driver=(WebDriver) new EdgeDriver();
	}
	else if (browser.equalsIgnoreCase("internetExplorer")) {
	     driver=(WebDriver) new InternetExplorerDriver();	
	}
	else if (browser.equalsIgnoreCase("safari")) {
		 driver=(WebDriver) new SafariDriver();
	}
	else {
	    driver=(WebDriver) new ChromeDriver();
	}
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	driver.get(url);
	}
	@AfterClass
	public void postCondition() {
		driver.quit();
}
}
