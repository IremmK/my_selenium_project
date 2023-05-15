package com.myfirstproject.practices.practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Q04_Calculator {
    WebDriver driver ;
    @Before
    public void setUp(){
        // Create chrome driver by using @Before annotation and WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void additionTest (){
        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("25");

        // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("30");

        // Click on Calculate
        driver.findElement(By.id("calculate")).sendKeys(Keys.ENTER);

        // Get the result
        String answer = driver.findElement(By.id("answer")).getText();

        // Verify the result
        Assert.assertEquals("55",answer);

        // Print the result
        System.out.println("answer = " + answer);
    }
    @Test
    public void multiplicationTest (){
        // Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        // Click on  Calculator under Micro Apps
        driver.findElement(By.id("calculatetest")).click();

        // Type any number in the first input
        driver.findElement(By.id("number1")).sendKeys("25");

        // Type any number in the second input
        driver.findElement(By.id("number2")).sendKeys("30");

        //select on the times
        WebElement functionDropDown = driver.findElement(By.id("function"));
        Select select = new Select(functionDropDown);
        select.selectByValue("times");

        // Click on Calculate
        driver.findElement(By.id("calculate")).sendKeys(Keys.ENTER);

        // Get the result
        String answer = driver.findElement(By.id("answer")).getText();

        // Verify the result
        Assert.assertEquals("750",answer);

        // Print the result
        System.out.println("answer = " + answer);
    }
    @After
    public void tearDown(){
        // Close the browser by using @After annotation
        driver.quit();
    }
}
