package com.cydeo.tests.avengers.week4;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExplicitWaitPractice extends TestBase {

    @Test
    public void explicit_wait_test(){

//   		- Go to "https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html"
           driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");

//   		- Click buttons in order
        WebElement start = driver.findElement(By.id("button00"));
        System.out.println(start.isEnabled());

        WebElement one = driver.findElement(By.id("button01"));
        System.out.println(one.isEnabled());

        WebElement two = driver.findElement(By.id("button02"));
        System.out.println(two.isEnabled());

        WebElement three = driver.findElement(By.id("button03"));
        System.out.println(three.isEnabled());

        // click start button
        start.click();

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        //click one button
        wait.until(ExpectedConditions.elementToBeClickable(one));
       // BrowserUtils.waitforClickability(driver,one);
        one.click();

        //click two button
       // wait.until(ExpectedConditions.elementToBeClickable(two));
        BrowserUtils.waitforClickability(driver,two);
        two.click();

        //click three button
        BrowserUtils.waitforClickability(driver,three);
        three.click();


//   		- Verify messages are equal after click all buttons
        WebElement text = driver.findElement(By.id("buttonmessage"));

//   				- All Buttons Clicked
        String expectedText = "All Buttons Clicked";
        String actualText = text.getText();
        Assert.assertEquals(actualText,expectedText);


//   				- Clickable Buttons
        expectedText = "Clickable Buttons";
        wait.until(ExpectedConditions.textToBe(By.id("buttonmessage"),expectedText));
        actualText = text.getText();
        Assert.assertEquals(actualText,expectedText);


//   				- Click Buttons In Order
        expectedText = "Click Buttons In Order";
        wait.until(ExpectedConditions.textToBePresentInElement(text,expectedText));
        actualText = text.getText();
        Assert.assertEquals(actualText,expectedText);



    }

}
