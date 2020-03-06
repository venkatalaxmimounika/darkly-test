package com.darkly.lib.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class CreateDriver {
	
	public static WebDriver getBrowserInstance() 
	{
		WebDriver driver = null;
		String properties = "./config-data/configuration.properties";
		String browser = DataHandlers.getDataFromProperties(properties, "browser");
		String url = DataHandlers.getDataFromProperties(properties, "url");
		
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./browser-servers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "./browser-servers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("if")) {
			System.setProperty("webdriver.chrome.driver", "./browser-servers/ie.exe");
			driver = new InternetExplorerDriver();
		}
		else {
			System.out.println("invalid browser");
			return null;
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		if(url.equalsIgnoreCase("prod")) {
			driver.get("https://tc-admin.timeforgedev.com/#/");
		}
		else {
			System.out.println("invalid url");
		}
		return driver;
	}

}
