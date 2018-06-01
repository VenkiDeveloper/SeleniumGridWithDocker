package com.seleniumdocker.sample;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/***
 * Start docker, execute below command in cmd prompt.
 * 
 * Chrome: docker run -d -P -p 5900:5900 --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-chrome-debug:3.12.0-boron
 * Firefox: docker run -d -P -p 5901:5900 --link selenium-hub:hub -v /dev/shm:/dev/shm selenium/node-firefox-debug:3.12.0-boron
 * to connect to the Chrome node on 5900 and the Firefox node on 5901.
 * 
 * VNC Server to allow you to visually see the browser being automated.
 * Open VNC client and connect to 127.0.0.1:5900 and enter password as secret.
 * 
 * @author venkatesh
 *
 */
public class StandAloneDebugBrowserWithDocker {
	WebDriver driver;
	@BeforeTest
    public void setUp() throws MalformedURLException {
		System.out.println("======> ABC==========>");
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        driver = new RemoteWebDriver(new URL("http://localhost:4555/wd/hub"), dc);
    }

    @Test
    public void abc() throws InterruptedException {
    	System.out.println("======> cbd==========>");
    	driver.get("http://www.google.com");
    	Assert.assertTrue(driver.getTitle().contains("Google"));
    	File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	try {
			FileUtils.copyFile(file, new File("Screenshots/"+file.getName()));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @AfterTest
    public void tearDown() throws InterruptedException {
    	System.out.println("======> ggg==========>");
        driver.quit();
    }   
}
