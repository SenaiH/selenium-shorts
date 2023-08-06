package com.cydeo.tests.avengers.week2;

import com.cydeo.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class EtsyTest {

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
    public void etsy_search_result_test(){

        //TC: Etsy checkbox and radio button
        //		1. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        //		2. Search for “wooden spoon”
        WebElement searchBox = driver.findElement(By.cssSelector("input#global-enhancements-search-query"));
        searchBox.sendKeys("wooden spoon"+ Keys.ENTER);

        BrowserUtils.sleep(3);

        //		3. Click on All Filters
        driver.findElement(By.xpath("//span[text()='All Filters']")).click();

        BrowserUtils.sleep(6);

        //		4. Select free shipping, on sale
        driver.findElement(By.xpath("//label[@for='special-offers-free-shipping']")).click();

        driver.findElement(By.xpath("//label[@for='special-offers-on-sale']")).click();

        BrowserUtils.sleep(6);

        //		5. Select under $25 Click on apply filters
        driver.findElement(By.xpath("//label[@for='price-input-1']")).click();
        driver.findElement(By.cssSelector("button[aria-label='Apply']")).click();

        BrowserUtils.sleep(6);

        //		6. Print count of results
        WebElement result = driver.findElement(By.xpath("//span[contains(text(),'results,')]"));
        System.out.println("result.getText() = " + result.getText());
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }


}
