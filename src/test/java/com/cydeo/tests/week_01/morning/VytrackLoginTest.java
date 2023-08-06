package com.cydeo.tests.week_01.morning;

import com.google.common.base.Verify;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class VytrackLoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        // 1- Setup the "browser driver"
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Go to "https://vytrack.com"
        driver.get("https://vytrack.com");

    }


    @Test(priority = 1)
    public void vytrack_title_verification_test(){
//        // 1- Setup the "browser driver"
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        // 2- Go to "https://vytrack.com"
//        driver.get("https://vytrack.com");

        // 3- Click Login label
        WebElement loginLink = driver.findElement(By.xpath("(//a[.='LOGIN'])[1]"));
        loginLink.click();

        // 3- Verify the title contains "Login"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Login";

        Assert.assertTrue(actualTitle.contains(expectedTitle),"Title verification is failed!");

    }

    @Test (priority = 2)
    public void vytrack_login_test() throws InterruptedException {
       // TC003 As a user I should be able to login with valid credentials

        // 3- Click Login label
        WebElement loginLink = driver.findElement(By.xpath("(//a[.='LOGIN'])[1]"));
        loginLink.click();

        // 4- Login to application with username as "User1" and password as "UserUser123"
        WebElement username = driver.findElement(By.cssSelector("#prependedInput"));
        username.sendKeys("User1");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("UserUser123" + Keys.ENTER);

        Thread.sleep(2000);

        // 5- Verify the title is "Dashboard"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";

        Thread.sleep(2000);

       // Assert.assertTrue(actualTitle.equals(expectedTitle));
        Assert.assertEquals(actualTitle,expectedTitle,"Title verification is failed!");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }




}
