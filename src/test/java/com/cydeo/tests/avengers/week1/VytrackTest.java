package com.cydeo.tests.avengers.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class VytrackTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        // 1- Setup the "browser driver"
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Go to "https://vytrack.com/"
        driver.get("https://vytrack.com/");

    }


    @Test
    public void vytrack_aboutus_link_test() throws InterruptedException {

        // 3- Click "About us" link
        WebElement aboutusLink = driver.findElement(By.xpath("(//a[@href='https://vytrack.com/about-us/'])[1]"));
        aboutusLink.click();

        Thread.sleep(3000);

        // 4- Verify the url contains "about-us"
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl= "about-us";

        Assert.assertTrue(actualUrl.contains(expectedUrl),"About us link url verification failed!");

    }

    @Test
    public void vytrack_login_hidden_password_test(){
       //TC003 As a user I should be able to see the password hidden as default
        //
        // 1- Setup the "browser driver"
        // 2- Go to "https://vytrack.com"
        // 3- Click Login label
        driver.findElement(By.xpath("(//a[text()='LOGIN'])[1]")).click();

        // 4- Login to application with username as "user1" and password as "UserUser123"
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("user1");

        WebElement password = driver.findElement(By.name("_password"));

        // 5- Verify the password is hidden
        String actualPasswordAttributeValue = password.getAttribute("type");
        String expectedPasswordAttributeValue = "password";

        Assert.assertEquals(actualPasswordAttributeValue,expectedPasswordAttributeValue,"Password hidden verification failed!");

    }

    @Test
    public void vytrack_all_links_test(){
//    TC005 As a user I should be able to see Home, About us, Our Approach, Product and Services, Contact and LOGIN labels are displayed
//
//  1-open a chrome browser
//  2-goto https://vytrack.com/
//  3-verify Home, About us, Our Approach, Product and Services, Contact and LOGIN links are displayed
        List<WebElement> allTopLinks = driver.findElements(By.xpath("//ul[@id='top-menu']/li/a"));

        for (WebElement eachLink : allTopLinks) {
            System.out.println(eachLink.getText());
            Assert.assertTrue(eachLink.isDisplayed());
        }


    }




    @AfterMethod
    public void tearDown(){
        // you can write here another line of codes to look at you all
        // Test methods to decide which line of codes  are common
        driver.quit();
    }







}
