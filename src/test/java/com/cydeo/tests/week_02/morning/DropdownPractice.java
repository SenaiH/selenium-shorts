package com.cydeo.tests.week_02.morning;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownPractice extends TestBase {


    @Test
    public void dropdown_test(){

        //  2-goto https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //  3-verify default option Select a State
        Select selectState = new Select(driver.findElement(By.id("state")));

        WebElement defaultOption = selectState.getFirstSelectedOption();

        String actualDefaultOption = defaultOption.getText();
        String expectedDefaultOption = "Select a State";

        Assert.assertEquals(actualDefaultOption,expectedDefaultOption,"Default state option verification failed!");

    }

    @Test
    public void dropdown_test2(){

       //As a user I should be able to select Alabama
        //  1-open a chrome browser
        //  2-goto https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

        //  3-select Alabama
        Select selectState = new Select(driver.findElement(By.id("state")));

//        selectState.selectByIndex(1);
//        selectState.selectByValue("AL");
        selectState.selectByVisibleText("Alabama");

        //  4-verify Alabama is selected

        WebElement currentSelectedOption = selectState.getFirstSelectedOption();

        String actualSelectedOption = currentSelectedOption.getText();
        String expectedSelectedOption = "Alabama";

        Assert.assertEquals(actualSelectedOption,expectedSelectedOption);

    }

}
