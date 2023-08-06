package com.cydeo.tests.avengers.week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class IframePractice {

//Task 1:  Iframe
//
// - Open "https://demoqa.com/frames"
// - Verify child frames texts are equal : "This is a sample page"

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // 1- Setup the "browser driver"
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void iframe_test(){

        // - Open "https://demoqa.com/frames"
        driver.get("https://demoqa.com/frames");

       // - Verify child frames texts are equal : "This is a sample page"

        //driver.switchTo().frame(2);
       // driver.switchTo().frame("frame1");
        // we locate iframe webelement inside frame method.
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='frame1']")));

        WebElement header = driver.findElement(By.id("sampleHeading"));

        String actualHeader = header.getText();
        String expectedHeader = "This is a sample page";

        Assert.assertEquals(actualHeader,expectedHeader,"Header text verification failed!");


        // if test steps continue to do any verification outside of this iframe
        // you have to go outside of this iframe with using parentFrame() or defaultContent()
//        driver.switchTo().parentFrame();// if iframe was nested, it will take to do parent frame
          driver.switchTo().defaultContent();// will take you directly to do MAIN HTML

        // verify "Frames" text in top header
        WebElement topHeader = driver.findElement(By.xpath("//div[@class='main-header']"));
        Assert.assertEquals(topHeader.getText(),"Frames");







    }

}
