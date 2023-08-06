package com.cydeo.tests.avengers.week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VytrackTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        // 1- Setup the "browser driver"
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2- Go to "https://vytrack.com/"
        driver.get("https://vytrack.com/");

    }

    @Test
    public void vytrack_all_links_test() {
//    TC005 As a user I should be able to see Home, About us, Our Approach, Product and Services, Contact and LOGIN labels are displayed
//
//  1-open a chrome browser
//  2-goto https://vytrack.com/
//  3-verify Home, About us, Our Approach, Products and Services, Contact and LOGIN links are displayed
        List<WebElement> allTopLinks = driver.findElements(By.xpath("//ul[@id='top-menu']/li/a"));

//        for (WebElement eachLink : allTopLinks) {
//            System.out.println(eachLink.getText());
//            Assert.assertTrue(eachLink.isDisplayed());
//        }

        List<String> actualTopLinks = new ArrayList<>();

        for (WebElement eachLink : allTopLinks) {
            String eachLinkText = eachLink.getText();
            actualTopLinks.add(eachLinkText);
        }

        List<String> expectedTopLinks = new ArrayList<>(Arrays.asList("Home", "About us", "Our Approach", "Products and Services", "Contact", "LOGIN"));

        Assert.assertEquals(actualTopLinks,expectedTopLinks,"Top links verification failed!");

    }
}