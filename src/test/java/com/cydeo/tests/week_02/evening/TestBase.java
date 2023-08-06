package com.cydeo.tests.week_02.evening;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class TestBase {

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

    @AfterMethod
    public void tearDown() {

        TC001.sleep(3);
        driver.close();
    }

}
