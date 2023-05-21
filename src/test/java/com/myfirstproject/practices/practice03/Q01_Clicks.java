package com.myfirstproject.practices.practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class Q01_Clicks extends TestBase {
     /*
    Given
        Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
    When
        Click all the buttons
    Then
        Assert all buttons clicked
     */

    @Test
    public void clickTest() {
        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        //Click all the buttons
        driver.findElement(By.id("onblur")).click();
        waitFor(1);
        driver.findElement(By.id("onclick")).click();//This click will be used for first 'onblur' button
        waitFor(1);
        driver.findElement(By.id("onclick")).click();//This click will be used for 'onclick' button

        WebElement onContextMenu = driver.findElement(By.id("oncontextmenu"));
        WebElement onDoubleClick = driver.findElement(By.id("ondoubleclick"));
        WebElement onFocus = driver.findElement(By.id("onfocus"));
        WebElement onKeyDown = driver.findElement(By.id("onkeydown"));
        WebElement onKeyUp = driver.findElement(By.id("onkeyup"));
        WebElement onKeyPress = driver.findElement(By.id("onkeypress"));
        WebElement onMouseOver = driver.findElement(By.id("onmouseover"));
        WebElement onMouseLeave = driver.findElement(By.id("onmouseleave"));//this click triggered the 'onmouseleave' element
        WebElement onMouseDown = driver.findElement(By.id("onmousedown"));//this click triggered the 'onmousedown' element

       Actions actions = new Actions(driver);
        actions.pause(Duration.ofSeconds(1)).
               contextClick(onContextMenu).pause(Duration.ofSeconds(1)).doubleClick(onDoubleClick).
               pause(Duration.ofSeconds(1)).click(onFocus).
                pause(Duration.ofSeconds(1)).click(onKeyDown).sendKeys(Keys.SPACE).
                pause(Duration.ofSeconds(1)).click(onKeyUp).keyDown(Keys.SPACE).pause(Duration.ofSeconds(1)).keyUp(Keys.SPACE).
                pause(Duration.ofSeconds(1)).click(onKeyPress).sendKeys(Keys.SPACE).
                pause(Duration.ofSeconds(1)).moveToElement(onMouseOver).
                pause(Duration.ofSeconds(1)).moveToElement(onMouseLeave).
                pause(Duration.ofSeconds(1)).click(onMouseDown).
                pause(Duration.ofSeconds(1)).click(onMouseDown).
               perform();





        //Assert all buttons clicked
        int numOfTriggeredElements = driver.findElements(By.xpath("//p[.='Event Triggered']")).size();
        assertEquals(11,numOfTriggeredElements);


    }
}