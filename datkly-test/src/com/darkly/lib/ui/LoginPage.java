package com.darkly.lib.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	 
	WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		this.driver =driver;
	}
	
	public WebElement getUsernameTextbox() 

	{
		try {
			WebElement ele = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
			return ele;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public WebElement getPasswordTextbox() {
		try {
			return driver.findElement(By.xpath("//input[@id='mat-input-1']"));
		}
		catch(Exception e) {
			return null;
		}
	}

	public WebElement getLoginButton() {
		try {
			return driver.findElement(By.xpath("//button[text=' LOGIN ']"));
		}catch(Exception e) {
			return null;
		}
	}

	public void waitForLoginPageToLoad() {
		WebDriverWait  wait = new WebDriverWait(driver , 30);
		wait.until(ExpectedConditions.visibilityOf(getUsernameTextbox()));
		wait.until(ExpectedConditions.visibilityOf(getPasswordTextbox()));
		wait.until(ExpectedConditions.visibilityOf(getLoginButton()));
	}
}
