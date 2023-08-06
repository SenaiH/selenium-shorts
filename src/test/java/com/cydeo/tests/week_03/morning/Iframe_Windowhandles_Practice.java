package com.cydeo.tests.week_03.morning;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class Iframe_Windowhandles_Practice extends TestBase {

    //Test website: http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target
    //
    //Test Scenario:
    //
    //Step 1- Go to the above URL.
    //Step 2- Get the current window’s handle and write to the console window. It must be the first window handle.
    //Step 3- Locate the “Visit W3Schools.com!” link and click it.
    //Step 4- Get all window handles and hold them in a list.
    //Step 5- Write to total window handle number to the console. It must be 2.
    //Step 6- Switch to the second window.
    //Step 7- Get the current window’s handle and write to the console window. It must be a second window handle.
    //Step 8- Check the upper left side logo in the second window.
    //Step 9- Go back (Switch) to the first window.
    //Step 10- Get the current window’s handle and write to the console window. It must be the first window handle.
    //Step 11- Check the See Run Button Text. It must contain “Run >” text.


    @Test
    public void iframe_windowhandle_test(){
        //Step 1- Go to the above URL.
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");

        //Step 2- Get the current window’s handle and write to the console window. It must be the first window handle.
        // We store main window handle from beginning to use it in next coming lines,
        // if any step wants us to go back to main window
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("mainWindowHandle = " + mainWindowHandle);

        //driver.switchTo().frame(2);
        driver.switchTo().frame("iframeResult");
       // driver.switchTo().frame(driver.findElement(By.id("iframeResult")));


        //Step 3- Locate the “Visit W3Schools.com!” link and click it.
        WebElement visitLink = driver.findElement(By.linkText("Visit W3Schools.com!"));
        visitLink.click();

        //Step 4- Get all window handles and hold them in a Set.
        Set<String> allWindowHandles = driver.getWindowHandles();

        //Step 5- Write to total window handle number to the console. It must be 2.
        System.out.println("allWindowHandles.size() = " + allWindowHandles.size());

        //Step 6- Switch to the second window.
        for (String eachWindow : allWindowHandles) {
            driver.switchTo().window(eachWindow);
        }

        //Step 7- Get the current window’s handle and write to the console window. It must be a second window handle.
        String currentWindowhandle = driver.getWindowHandle();
        System.out.println("currentWindowhandle = " + currentWindowhandle);

        //Step 8- Check the upper left side logo in the second window.
        WebElement logo = driver.findElement(By.xpath("//a[@title='Home']/i"));
        Assert.assertTrue(logo.isDisplayed(),"Logo did not displayed!");

        //Step 9- Go back (Switch) to the first window.
        driver.switchTo().window(mainWindowHandle);

        //Step 10- Get the current window’s handle and write to the console window. It must be the first window handle.
        System.out.println("Main Window handle= " + driver.getWindowHandle());

        //Step 11- Check the See Run Button Text. It must contain “Run ❯” text.
        WebElement runBtn = driver.findElement(By.id("runbtn"));
        Assert.assertTrue(runBtn.getText().contains("Run ❯"));

    }

}
