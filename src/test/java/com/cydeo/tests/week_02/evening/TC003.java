package com.cydeo.tests.week_02.evening;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TC003 extends TestBase{


    @Test
    public void tes003() {
      //  TC003 As a user I should be able to see default option as Select a State
      /*
      WE CAN DELETE THAT STEP BECAUSE WE DID IN TESTBASE CLASS
        //  1-open a chrome browser
        //  2-goto https://practice.cydeo.com/

       */
      //  3-click Dropdown
        TC001.clickElementForPractice(driver,"Dropdown");
      //  4-verify default option Select a State

        WebElement stateElement = driver.findElement(By.xpath("//select[@id='state']"));
        Select select=new Select(stateElement);
        String actualText = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualText,"Select a State");


    }


}
