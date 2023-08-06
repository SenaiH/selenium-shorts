package com.cydeo.tests.week_01.evening;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumIntro {

    public static void main(String[] args) {
        //each time we will type first steps one by one then we will go on with coding

        //   **  TC001 As a user I should be able to see Login label is displayed

        //  1-open a chrome browser
        //first we will setup our browser which browser we want to work
        WebDriverManager.chromedriver().setup();
        //Then we will create an object in order to call the methods
        WebDriver driver = new ChromeDriver(); //we are implementing polymorphism which is one of the OOP
        // left side interface right side object
        //then you can manage your window
        driver.manage().window().maximize();

        //  2-goto https://vytrack.com/
        //until now you will have one browser with empty url
        // in order to go to url we can use get method
        driver.get("https://vytrack.com/");
        //  3-verify Login is displayed
        // in order to check the element first we need to locate the element by using locator
        // we have 8 different locators  when we check the tag we have a tag it means we can use linkText () or partialLinkText()

        WebElement loginLink = driver.findElement(By.linkText("LOGIN"));
        String result = loginLink.isDisplayed() ? "PASSED" : "FAILED";
        System.out.println(result);

        //at the end we can close it
        driver.close();

    }
}
