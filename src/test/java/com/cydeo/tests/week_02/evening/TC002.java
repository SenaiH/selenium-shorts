package com.cydeo.tests.week_02.evening;

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

public class TC002 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //  1-open a chrome browser
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //  2-goto https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");

    }

    @Test
    public void test002() {

    //  **  TC002 As a user I should be able to select my favorite color and sport

    //  3-click Radio Buttons

        TC001.clickElementForPractice(driver,"Radio Buttons");

    //  4-verify title contains Radio buttons
        Assert.assertEquals(driver.getTitle(),"Radio buttons");
    //  5-select the favorite color as Red
        WebElement red = clickAndReturn("Yellow");
        //  6-verify the Red is selected
       Assert.assertTrue(red.isSelected());
    //  7-select the favorite sport as Football
        WebElement football = clickAndReturn("Football");

        //  8-verify the Football is selected
        Assert.assertTrue(football.isSelected());

    }

    public WebElement clickAndReturn(String color){
        String locator="//label[.='"+color+"']/../input";
        WebElement element = driver.findElement(By.xpath(locator));
        element.click();
        return element;
    }

    @AfterMethod
    public void tearDown() {

        TC001.sleep(3);
        driver.close();
    }
}
