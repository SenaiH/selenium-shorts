package com.cydeo.tests.week_01.evening;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VytrackTests {

    //if you use same reference for all tests you can make your reference global
    WebDriver driver;

    //if you are doing some steps before each test we can create one method  with  @BeforeMethod annotation
    @BeforeMethod
    public void setUp() {
        // 1- Setup the "browser driver"
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //if you do not want to face problem about findElement method you can use implicitlyWait method it will wait
        // for 10 seconds then it will throw exception
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Go to "https://vytrack.com"
        driver.get("https://vytrack.com");

    }


    //after learning testng then we will not use main method instead of that we will use method with @Test annotation

    @Test
    public void TC002() {
        // 3- Click Login label
        //normally we used linkText let's use xpath in here
        WebElement loginLink = driver.findElement(By.xpath("(//a[.='LOGIN'])[1]"));
        loginLink.click();

        // 4- Verify the title contains "Login"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Login";

        //After that we will not use if statements then we will use testng methods are coming from Assert class
        Assert.assertTrue(actualTitle.contains(expectedTitle), "Title verification is failed!");
    }


    @Test
    public void TC003() {
        // 3- Click Login label
        //normally we used linkText let's use xpath in here
        WebElement loginLink = driver.findElement(By.xpath("(//a[.='LOGIN'])[1]"));
        loginLink.click();

        // 4- Login to application with username as "User1" and password as "UserUser123"
        //locate the username
        WebElement username = driver.findElement(By.cssSelector("#prependedInput"));
        //send text into textbox with sendKeys method
        username.sendKeys("User1");

        //locate the password
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        //send text into textbox with sendKeys method
        password.sendKeys("UserUser123");



        //locate the login button
        WebElement loginButton = driver.findElement(By.xpath("//button"));
        //click button
        loginButton.click();

        sleep(3);
        // 5- Verify the title is "Dashboard"
        String actualTitle = driver.getTitle();
        String expectedTitle = "Dashboard";
        sleep(3);
        Assert.assertEquals(actualTitle, expectedTitle, "Title verification is failed!");
    }

    @Test
    public void TC004() {
        // 3- Click Login label
        //normally we used linkText let's use xpath in here
        WebElement loginLink = driver.findElement(By.xpath("(//a[.='LOGIN'])[1]"));
        loginLink.click();

        // 4- Login to application with username as "User1" and password as "UserUser123"
        //locate the username
        WebElement username = driver.findElement(By.cssSelector("#prependedInput"));
        //send text into textbox with sendKeys method
        username.sendKeys("User1");

        //locate the password
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        //send text into textbox with sendKeys method
        password.sendKeys("UserUser123");

       // 5- Verify the password is hidden
        String actualType = password.getAttribute("type");
        String expectedType="password";
        sleep(3);
        Assert.assertEquals(actualType, expectedType);
    }


    @Test
    public void TC005() {
        //wait for page loading
        sleep(1);
       // 3-verify Home, About us, Our Approach, Product and Services, Contact and LOGIN labels are displayed
        List<WebElement> menuElements = driver.findElements(By.xpath("//ul[@id='top-menu']/li"));
        //we got the six element now we need to get the each element text and put inside the List<String> so we need
        // to use for loop

        List<String> actualMenuLabels=new ArrayList<>();
        for (WebElement menuElement : menuElements) {
            //get each element text one by one
            String menuElementText = menuElement.getText();
            //put inside the  actual list
            actualMenuLabels.add(menuElementText);
        }
        List<String> expectedMenuLabels=new ArrayList<>(Arrays.asList("Home", "About us", "Our Approach", "Products " +
                "and Services", "Contact", "LOGIN"));

        Assert.assertEquals(actualMenuLabels,expectedMenuLabels);



    }









    //if you want to same actions after each test you can create one method with @AfterMethod annotation
    @AfterMethod
    public void tearDown() {
        sleep(1);
        driver.close();
    }

    //we can create a reusable method.

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {

        }
    }
}
