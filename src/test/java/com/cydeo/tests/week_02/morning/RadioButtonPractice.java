package com.cydeo.tests.week_02.morning;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonPractice extends TestBase {

//As a user I should be able to select my favorite color and sport
//
//  1-open a chrome browser
//  2-goto https://practice.cydeo.com/
//  3-click Radio Buttons
//  4-verify title contains Radio buttons
//  5-select the favorite color as Red
//  6-verify the Red is selected
//  7-select the favorite sport as Football
//  8-verify the Football is selected


    @Test
    public void radio_button_test(){
        //  2-goto https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");

       //  3-click Radio Buttons
        BrowserUtils.clickOption(driver,"Radio Buttons");

        BrowserUtils.sleep(6);

        //  4-verify title is Radio buttons
       // Assert.assertEquals(driver.getTitle(),"Radio buttons");
        BrowserUtils.verifyTitle(driver,"Radio buttons");

       //  5-select the favorite color as Red
       // WebElement redButton = driver.findElement(By.cssSelector("#red"));
        WebElement redButton = driver.findElement(By.id("red"));
        redButton.click();

       //  6-verify the Red is selected
        Assert.assertTrue(redButton.isSelected());

        BrowserUtils.sleep(6);

       //  7-select the favorite sport as Football
        WebElement footballButton = driver.findElement(By.id("football"));
        footballButton.click();

        BrowserUtils.sleep(6);

       //  8-verify the Football is selected
       Assert.assertTrue(footballButton.isSelected());

    }
}
