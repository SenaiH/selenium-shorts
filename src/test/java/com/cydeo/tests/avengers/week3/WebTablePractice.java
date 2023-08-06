package com.cydeo.tests.avengers.week3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class WebTablePractice {

//Task 2:   Web Table
//
//	        - Open "http://practice.cydeo.com/tables"
//	        - Print out all infromation for firstname ="Frank"
//	        - Verify
//	        		- email equals "fbach@yahoo.com"
//
//	       NOTE : This task needs to work for
//	                firstname = Jason
//	                email     = jdoe@hotmail.com

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // 1- Setup the "browser driver"
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void webtable_test(){
//	        - Open "https://practice.cydeo.com/tables"
        driver.get("https://practice.cydeo.com/tables");

//	        - Print out all information for firstname ="Frank"
        WebElement frankRow = driver.findElement(By.xpath("//table[@id='table1']//td[.='Frank']/.."));
        System.out.println("frankRow.getText() = " + frankRow.getText());

//	        - Verify
//	        		- email equals "fbach@yahoo.com"
        WebElement frankEmail = driver.findElement(By.xpath("//table[@id='table1']//td[.='Frank']/../td[.='fbach@yahoo.com']"));

        Assert.assertEquals(frankEmail.getText(),"fbach@yahoo.com");


        // print out all table
        WebElement alltable = driver.findElement(By.xpath("//table[@id='table1']"));
        System.out.println("alltable.getText() = " + alltable.getText());

        // print out all Website coloumn
        List<WebElement> websiteCol = driver.findElements(By.xpath("//table[@id='table1']//th[@class='header']//span[.='Web Site']/../../../../tbody//td[contains(text(),'http')]"));
        for (WebElement eachCol : websiteCol) {
            System.out.println("eachCol.getText() = " + eachCol.getText());
        }


        // xpath of location email from name --> //table[@id='table1']//td[.='Frank']/../td[.='fbach@yahoo.com']
   // xpath of email from first name --> //table[@id='table1']//td[.='Frank']/following-sibling::td[1]

   // xpath of last name from first name --> //table[@id='table1']//td[.='Frank']/preceding-sibling::td

    }
}
