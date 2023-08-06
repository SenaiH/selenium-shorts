package com.cydeo.tests.week_02.morning;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxPractice extends TestBase {

    //TC001 As a user I should be able to click checkboxes
    //
    //  1-open a chrome browser
    //  2-goto https://practice.cydeo.com/
    //  3-click Checkboxes
    //  4-verify title contains Checkboxes
    //  5-click Checkbox 1
    //  6-verify the Checkbox 1 is checked
    //  7-click Checkbox 2
    //  8-verify the Checkbox 2 is checked

    @Test
    public void checkbox_text(){
        //  2-goto https://practice.cydeo.com/
        driver.get("https://practice.cydeo.com/");

        //  3-click Checkboxes
        // Since I will not need Checkbox webelement in next coming lines, I did not store in WebElement
        //driver.findElement(By.linkText("Checkboxes")).click();

        BrowserUtils.clickOption(driver,"Checkboxes");

        //  4-verify title equals Checkboxes
       // Assert.assertTrue(driver.getTitle().equals("Checkboxes"));
        Assert.assertEquals(driver.getTitle(),"Checkboxes");

//        String actualTitle = driver.getTitle();
//        String expectedTitle = "Checkboxes";
//
//       // Assert.assertTrue(actualTitle.equals(expectedTitle));
//        Assert.assertEquals(actualTitle,expectedTitle);



        //  5-click Checkbox 1
        WebElement checkbox1 = driver.findElement(By.id("box1"));
        checkbox1.click();

        BrowserUtils.sleep(3);

        //  6-verify the Checkbox 1 is selected
        Assert.assertTrue(checkbox1.isSelected(),"checkbox1 verification failed!");


        //  7-click Checkbox 2
        WebElement checkbox2 = driver.findElement(By.id("box2"));
        checkbox2.click();

        //  8-verify the Checkbox 2 is not selected
        Assert.assertTrue(!checkbox2.isSelected(),"checkbox2 verification failed!");


    }

}
