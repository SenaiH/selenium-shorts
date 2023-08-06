package com.cydeo.tests.week_01.morning;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class VytrackLoginPage {

    //TC001 As a user I should be able to see Login label is displayed
    //  1-open a chrome browser
    //  2-goto https://vytrack.com/
    //  3-verify Login is displayed

    public static void main(String[] args) {

        //  1-open a chrome browser

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        // it will go to the all findElelement() method implicitly to give them time if they need
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        //  2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");

        //  3-verify LOGIN is displayed

        WebElement loginLink = driver.findElement(By.linkText("LOGIN"));

        String actualText = loginLink.getText();
        String expectedText = "LOGIN";

        // if you are looking for exact matching
        if(actualText.equals(expectedText)){
            System.out.println("Text verification is passed!");
        }else{
            System.out.println("Text verification is failed!");
        }



        // if you are looking for any text matching
       if(loginLink.isDisplayed()){
           System.out.println("Login link is displayed");
       }else{
           System.out.println("Login link is not displayed!");
       }


    }
}
