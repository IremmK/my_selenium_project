package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.Set;

public class Day07_WindowHandle1 extends TestBase {
    /*
    Method name:windowHandle
Given user is on the https://the-internet.herokuapp.com/windows
Then user verifies the text : “Opening a new window”
Then user verifies the title of the page is “The Internet”
When user clicks on the “Click Here” button
Then user verifies the new window title is “New Window”
Then user verifies the text:  “New Window”
When user goes back to the previous window and then verifies the title : “The Internet”
     */
    @Test
    public void windowHandle () throws InterruptedException {
        //Given user is on the https://the-internet.herokuapp.com/windows
        driver.get("https://the-internet.herokuapp.com/windows");

        //Then user verifies the text : “Opening a new window”
        String page1HeaderText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("Opening a new window",page1HeaderText);

        //Then user verifies the title of the page is “The Internet”
        Assert.assertEquals("The Internet",driver.getTitle());

        //When user clicks on the “Click Here” button
        driver.findElement(By.xpath("//a[.='Click Here']")).click();

        //LET'S GET WINDOW 1 HANDLE FIRST CAUSE WE MAY NEED TO SWITCH BACK TO WINDOW 1
        String window1Handle = driver.getWindowHandle();
        System.out.println("window1Handle = " + window1Handle);//window1Handle = DF149D2E73930FFDFE536AB20F472874

        //DRIVER IS STILL ON WINDOW 1
        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println("allWindowHandles = " + allWindowHandles);//allWindowHandles = [EAB6564B71D7810BF3816F6929D578FA, D805693977AE9EB0E2C59CBA5236A3FC]
        for(String eachHandle : allWindowHandles ){
            if(!eachHandle.equals(window1Handle)){//if we are not on window1, then we must be on window2. then switch on it
                driver.switchTo().window(eachHandle);
                break;
            }
        }
        //AFTER THE SWITCH HELPED BY FOR, NOW WE ARE ON WINDOW2

        //Then user verifies the new window 2 title is “New Window”
        Assert.assertEquals("New Window",driver.getTitle());

        //Then user verifies the text:  “New Window”
        String page2HeaderText = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertEquals("New Window",page2HeaderText);

        String window2Handle = driver.getWindowHandle();//We can use this window 2 id if we want to switch back to

        //When user goes back to the previous window and then verifies the title : “The Internet”
        driver.switchTo().window(window1Handle);
        Assert.assertEquals("The Internet",driver.getTitle());
        Thread.sleep(5000);

        //SWITCH BACK TO WINDOW 2
        driver.switchTo().window(window2Handle);
        Thread.sleep(5000);

        //SWITCH BACK TO WINDOW 1
        driver.switchTo().window(window1Handle);
        Thread.sleep(5000);

        //SWITCH BACK TO WINDOW 2
        driver.switchTo().window(window2Handle);
        Thread.sleep(5000);

        //SWITCH BACK TO WINDOW 1
        driver.switchTo().window(window1Handle);
        Thread.sleep(5000);



    }
}
