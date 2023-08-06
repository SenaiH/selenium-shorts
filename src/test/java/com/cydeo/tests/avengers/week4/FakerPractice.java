package com.cydeo.tests.avengers.week4;

import com.cydeo.tests.base.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FakerPractice extends TestBase {

    @Test
    public void faker_test(){

        //        1. Launch browser
        //        2. Navigate to url 'https://automationexercise.com/login'
         driver.get("https://automationexercise.com/login");

        //        3. Verify 'New User Signup!' is visible
        WebElement newUserSignup = driver.findElement(By.xpath("//h2[.='New User Signup!']"));
        Assert.assertTrue(newUserSignup.isDisplayed());

        //        4. Enter name and email address
        Faker faker = new Faker();

        WebElement name = driver.findElement(By.xpath("//input[@name='name']"));
        name.sendKeys(faker.name().firstName());

        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys(faker.internet().emailAddress());

        //        5. Click 'Signup' button
        driver.findElement(By.xpath("//button[.='Signup']")).click();

        //        6. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement header = driver.findElement(By.xpath("//h2[.='Enter Account Information']"));
        Assert.assertTrue(header.isDisplayed());

        //        7. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//input[@value='Mr']")).click();

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(faker.internet().password());

        Select selectDay = new Select(driver.findElement(By.id("days")));
        selectDay.selectByIndex(3);

        Select selectMonth = new Select(driver.findElement(By.id("months")));
        selectMonth.selectByValue("4");

        Select selectYear = new Select(driver.findElement(By.id("years")));
        selectYear.selectByVisibleText("2004");


        //        8. Select checkbox 'Sign up for our newsletter!'
         driver.findElement(By.id("newsletter")).click();

        //        9. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();

        //        10. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        //        11. Click 'Create Account button'
        //        12. Verify that 'ACCOUNT CREATED!' is visible
        //        13. Click 'Continue' button
        //        14. Verify that 'Logged in as username' is visible
    }


}
