package com.cydeo.tests.avengers.week4;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionsPractice extends TestBase {


    @Test
    public void actions_test(){

        //    - Go to  "https://www.globalsqa.com/demo-site/draganddrop/"
            driver.get("https://www.globalsqa.com/demo-site/draganddrop/");

            driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame.lazyloaded")));

        //    - Drag and Drop "High Tatras" and "High Tatras 2" into "Trash"
        WebElement firstImg = driver.findElement(By.xpath("//h5[.='High Tatras']"));
        WebElement secondImg = driver.findElement(By.xpath("//h5[.='High Tatras 2']"));

        WebElement trashBox = driver.findElement(By.id("trash"));

        Actions actions = new Actions(driver);

        // for first image we used drag and drop method
        actions.dragAndDrop(firstImg,trashBox).perform();

        // for second image we used channing method
        actions.moveToElement(secondImg)
                .clickAndHold()
                .moveToElement(trashBox)
                .pause(3000)
                .release().perform();

        BrowserUtils.sleep(3);

        //    - Verify Trash has 2 photo
        List<WebElement> trashImgs = driver.findElements(By.xpath("//div[@id='trash']//li"));

        Assert.assertTrue(trashImgs.size()==2);


    }

}
