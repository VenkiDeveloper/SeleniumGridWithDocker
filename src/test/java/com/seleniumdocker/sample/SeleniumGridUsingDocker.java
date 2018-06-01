package com.seleniumdocker.sample;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Start docker, execute below commands in cmd prompt.
 * Selenium Hub: docker run -d -p 4444:4444 --name selenium-hub selenium/hub:3.12.0-boron
 * ChromE Node: docker run -d --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-chrome:3.12.0-boron
 * Firefox Node: docker run -d --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-firefox:3.12.0-boron
 * 
 * Grid console: http://localhost:4444/grid/console
 * 
 */
public class SeleniumGridUsingDocker {
	WebDriver driver;
	@BeforeTest
    public void setUp() throws MalformedURLException {
		System.out.println("======> ABC==========>");
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setPlatform(Platform.LINUX);
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
