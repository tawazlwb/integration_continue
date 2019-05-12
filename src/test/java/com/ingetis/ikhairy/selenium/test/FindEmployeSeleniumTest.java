package com.ingetis.ikhairy.selenium.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindEmployeSeleniumTest {
    
    public static String firstName = "Andrew";
    public static String lastName = "Fuller";
    
    @Test
    public void FindEmployeTest() throws MalformedURLException, InterruptedException {
        WebDriver driver = FindEmployeSeleniumTest.getChromeDriver();
        
        // Test
        FindEmployeSeleniumTest.runTest(driver);
        TimeUnit.SECONDS.sleep(3);
        
        FindEmployeSeleniumTest.closeChromeDriver(driver);
    }
    
    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
        return new ChromeDriver();
    }
    
    public static void closeChromeDriver(WebDriver driver) {
        driver.quit();
    }
    
    public static void runTest(WebDriver driver) throws InterruptedException {
        driver.get("http://localhost:8888/integration_continue/gestion");
        TimeUnit.SECONDS.sleep(1);
        WebElement empIDElement = driver.findElement(By.name("employeID"));
        empIDElement.sendKeys("1");
        TimeUnit.SECONDS.sleep(1);
        driver.findElement(By.className("chercher")).click();
        WebElement empFirstNameElement = driver.findElement(By.name("firstName"));
        WebElement empLastNameElement = driver.findElement(By.name("lastName"));
        
        Assert.assertTrue(empFirstNameElement.getAttribute("value").equals(FindEmployeSeleniumTest.firstName));
        Assert.assertTrue(empLastNameElement.getAttribute("value").equals(FindEmployeSeleniumTest.lastName));
    }
}
