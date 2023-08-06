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
import java.util.Set;

public class WindowHandlePractice {

    //Task 3:  Window Handles
    //
    //   - Navigate to "https://testpages.herokuapp.com/styled/windows-test.html"
    //   - Click Basic Ajax in new page
    //   - Click Attributes in new page
    //   - Click Alerts In A New Window From JavaScript
    //   - Switch to "Element Attributes Examples" window
    //   - Assert header is Element Attributes Examples

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
    public void window_handle_test(){
        //   - Navigate to "https://testpages.herokuapp.com/styled/windows-test.html"
         driver.get("https://testpages.herokuapp.com/styled/windows-test.html");

         // getWindowHandle() method gives current focus window id
         String mainWindowhandle = driver.getWindowHandle();
        System.out.println("mainWindowhandle = " + mainWindowhandle);


        //   - Click Basic Ajax in new page
        driver.findElement(By.id("gobasicajax")).click();

        //   - Click Attributes in new page
        driver.findElement(By.id("goattributes")).click();

        //   - Click Alerts In A New Window From JavaScript
        driver.findElement(By.id("goalerts")).click();

        // getWindowHandles() gives all windows handle id
        // Since all window handles are unique, getWindowhandles() method return to the Set<String>
        Set<String> allWindowHandles = driver.getWindowHandles();


        //   - Switch to "Element Attributes Examples" window
        //   - Assert header is Element Attributes Examples
        for (String eachWindow : allWindowHandles) {

            driver.switchTo().window(eachWindow);
            System.out.println("driver.getTitle() = " + driver.getTitle());
            System.out.println("driver.getWindowHandle() = " + driver.getWindowHandle());

            if(driver.getTitle().contains("Attributes")){
                WebElement header = driver.findElement(By.xpath("//h1[.='Element Attributes Examples']"));
                Assert.assertTrue(header.getText().equals("Element Attributes Examples"));
                break;
            }
        }







    }
}
