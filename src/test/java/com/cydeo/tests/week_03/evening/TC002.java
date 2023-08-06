package com.cydeo.tests.week_03.evening;

import com.cydeo.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class TC002 extends TestBase {

    @Test
    public void test002() {

        //   url = http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html

        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
        //   Task 2:  Web Table

        //   Step 1- Click on calendar
        WebElement element = driver.findElement(By.xpath("//input[@id='datepicker']"));
        element.click();

        //   Step 2- Get all td of tables using findElements method
        List<WebElement> elements = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));

        //   Step 3- using for loop get the text of all elements
        String str=" "; //not empty but blank
        for (WebElement webElement : elements) {
            String webElementText = webElement.getText();
            if (!webElementText.trim().isEmpty())
                System.out.println(webElementText);
        }

        //   Step 4- using if else condition we will check the specific date



        //   Step 5- If the date is matched then click and break the loop.
        int day=6;
/*
        for (WebElement webElement : elements) {
            String webElementText = webElement.getText();
            if (webElementText.equals(day+"")){
                webElement.click();
                break;
            }

        }

 */
        selectDay(day);

        //how we can get the input value
        System.out.println(element.getAttribute("value"));


    }

    public void selectDay(int day){
        String locator="//td[.='"+day+"']";
        driver.findElement(By.xpath(locator)).click();
    }
}
