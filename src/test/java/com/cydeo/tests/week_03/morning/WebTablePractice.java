package com.cydeo.tests.week_03.morning;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablePractice extends TestBase {


    @Test
    public void webtable_test() {

        //url = http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html

        //Task 2:  Web Table

        //Step 1- Click on calendar

        driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");


        WebElement calendarInput = driver.findElement(By.id("datepicker"));
        calendarInput.click();

        //Step 2- Get all td of tables using findElements method
        List<WebElement> allDays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        //Step 3- using for loop get the text of all elements
        //Step 4- using if else condition we will check the specific date
        //Step 5- If the date is matched then click and break the loop.

        for (int i = 0; i < 31; i++) {
            for (WebElement element : allDays) {
                if (element.getText().equalsIgnoreCase("" + i)) {
                    element.click();
                }
            }

        }


//        for (WebElement eachDay : allDays) {
//
//            String day = eachDay.getText();
//            System.out.println("eachDay.getText() = " + day);
//
//            if(day.equalsIgnoreCase("5")){
//                eachDay.click();
//                break;
//            }
//        }
//

    }

        }





