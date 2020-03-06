package com.darkly.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.darkly.lib.ui.LoginPage;
import com.darkly.lib.utils.CreateDriver;
import com.darkly.lib.utils.DataHandlers;

public class TestSample {
	
	WebDriver driver;
	LoginPage lp; 
	@BeforeMethod
	public void preCondition() {
		driver = CreateDriver.getBrowserInstance();
		lp = new LoginPage(driver);
	}
    @AfterMethod
    public void postConsition() {
    	driver.close();
    }
    @Test
    public void test_sample() {
    	String username = DataHandlers.getDataFromExcel("./test-data/data.xlsx","sheet1",1,0);
    	String password = DataHandlers.getDataFromExcel("./test-data/data.xlsx","sheet1",1,1);
    	lp.waitForLoginPageToLoad();
    	lp.getUsernameTextbox().sendKeys(username);
    	lp.getPasswordTextbox().sendKeys(password);
    	lp.getLoginButton().click();    	
    }
}
