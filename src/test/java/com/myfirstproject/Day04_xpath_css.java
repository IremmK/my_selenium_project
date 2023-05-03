package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_xpath_css {
//    Create a class: Locators
//    When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//    And enter username
//    And enter password
//    And click on submit button
//    Then verify the login is successful
//    Then logout the application
//    Then verify the logout is successful
    WebDriver driver;
    @Before
    public void setUp (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void loginTest (){
        //login
        //username
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");
        //password
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");
        //login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        //Verify the login
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

        //logout
        //profile
        WebElement profile = driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
        profile.click();
        //logout button
        WebElement logoutButton = driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']"));
        logoutButton.click();
        //Verify the logout
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));

    }
    @Test
    public void loginTest2 (){
        //login
        //username
        driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
        //password
        driver.findElement(By.cssSelector("input[type='password']")).sendKeys("admin123");
        //login button
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        //Verify the login
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

        //logout
        //profile
        WebElement profile = driver.findElement(By.cssSelector("span[class='oxd-userdropdown-tab']"));
        profile.click();
        //logout button
        WebElement logoutButton = driver.findElement(By.cssSelector("a[href='/web/index.php/auth/logout']"));
        logoutButton.click();
        //Verify the logout
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));



    }
}
