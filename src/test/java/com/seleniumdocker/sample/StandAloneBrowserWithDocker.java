package com.seleniumdocker.sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StandAloneBrowserWithDocker {
	WebDriver driver;
	@BeforeTest
    public void setUp() throws MalformedURLException {
		System.out.println("======> ABC==========>");
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
    }

    @Test
    public void abc() throws InterruptedException {
    	System.out.println("======> cbd==========>");
    	driver.get("http://www.google.com");
    	Assert.assertTrue(driver.getTitle().contains("Google"));
    }
    
    @AfterTest
    public void tearDown() throws InterruptedException {
    	System.out.println("======> ggg==========>");
        driver.quit();
    }   
}
