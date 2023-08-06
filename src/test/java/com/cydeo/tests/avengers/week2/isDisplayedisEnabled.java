package com.cydeo.tests.avengers.week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class isDisplayedisEnabled {

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
    public void isDisplayed_isEnabled_test(){
        //TC: isDisplayed/isEnabled
        //
        //   1- Navigate to "https://www.uitestpractice.com/"
        driver.get("http://www.uitestpractice.com/");

        //   2- Verify main page is launched;


        //   3-"Testing Controls" Tab should be displayed on left top (visible and enabled)
    }


    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
