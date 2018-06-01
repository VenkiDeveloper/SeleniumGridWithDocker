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
/**
 * Start docker, execute below commands in cmd prompt.
 * docker pull elgalu/selenium
 * docker pull dosel/zalenium
 * 
 * Run the below command to start the zaleniukm-selenium-grid
 * docker run --rm -ti --name zalenium -p 4444:4444 -p 5555:5555 \
 *   -v /var/run/docker.sock:/var/run/docker.sock \
 *   -v /tmp/videos:/home/seluser/videos \
 *   dosel/zalenium start
 *   
 *   Zalenium – Live Preview:
 *   http://localhost:4444/grid/admin/live#
 *   DashBoard: 
 *    http://localhost:4444/dashboard
 *    
 *  By default, our Selenium grid will have 1 Chrome and 1 Firefox container.
 *   If you need more, say 3 chrome containers, 2 firefox then use below arguments
 * –chromeContainers 3
 * –firefoxContainers 2
 * 
 * docker run --rm -ti --name zalenium -p 4444:4444 -p 5555:5555 \
 *   -v /var/run/docker.sock:/var/run/docker.sock \
 *   -v /tmp/videos:/home/seluser/videos \
 *   dosel/zalenium start --chromeContainers 3 --firefoxContainers 2
 *   
 *   
 * 
 * @author venkatesh
 */
public class SelniumGridUsingZalenium {
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
