package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class Day13_FluentWait extends TestBase {
    //    Create a class:FluentWait
//    Create a method: fluentWait
//    Go to https://the-internet.herokuapp.com/dynamic_loading/1
//    When user clicks on the Start button
//    Then verify the ‘Hello World!’ Shows up on the screen
    @Test
    public void fluentWait (){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebElement startButton = driver.findElement(By.xpath("//div[@id='start']//button"));
        startButton.click();
        //TRYING FLUENT WAIT

        //1.Step: Create fluent wait object
        Wait<WebDriver> wait = new FluentWait<>(driver)//creating wait object
                .withTimeout(Duration.ofSeconds(30))//total wait
                .pollingEvery(Duration.ofSeconds(2))//how often driver checks the elements
                .withMessage("ignoring No Such Element Exception")//adding message
                .ignoring(NoSuchElementException.class);//ignoring exception

        //2.Step: use the wait object to handle the wait issue
        WebElement hello = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        Assert.assertEquals("Hello World!",hello.getText());

    }
}
