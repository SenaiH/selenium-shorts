package com.cydeo.tests.avengers.week1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Vytrack_AboutUsLink {

    // TC001 As a user I should be able to see Login label is displayed
    //
    //  1-open a chrome browser
    //  2-goto https://vytrack.com/
    //  3-verify "About us" is displayed

    public static void main(String[] args) throws InterruptedException {
        //  1-open a chrome browser
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //  2-goto https://vytrack.com/
        driver.get("https://vytrack.com/");

        Thread.sleep(3000);

        //  3-verify "About us" is displayed
        WebElement aboutusLink = driver.findElement(By.linkText("About us"));

        if(aboutusLink.isDisplayed()){
            System.out.println("About us text verification passed!");
        }else{
            System.out.println("About us text verification failed!");
        }

        // driver.close();

        driver.quit();

    }
}
