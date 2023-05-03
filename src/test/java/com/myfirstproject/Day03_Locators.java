package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day03_Locators {
    /*
    Create a class: Locators
When user goes to : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
And enter username
And enter password
And click on submit button
Then verify the login is successful
     */
    WebDriver driver;
    @Before
    public void setUp(){
        //this method will be use for pre-conditions
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @After
    public void tearDown (){
        //this method will be used for after conditions
        driver.quit();
    }

    @Test
    public void loginTest () throws InterruptedException {
        //locating username
        driver.findElement(By.name("username")).sendKeys("Admin");

        //locating password
        driver.findElement(By.name("password")).sendKeys("admin123");

        //locating the button
        driver.findElement(By.tagName("button")).click();

        //Homework : Verify if login is successful
        //Verify if the URL contains dashboard
        //If URL contains dashboard login is successful or else unsuccessful
        Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"));

        //Then logout the application
        //Then verify the logout is successful

        //putting hard wait. This is a java wait.
        Thread.sleep(3000);
        //locating the menu
        driver.findElement(By.className("oxd-userdropdown-tab")).click();
        //putting hard wait.
        Thread.sleep(3000);
        driver.findElement(By.linkText("Logout")).click();

        //Asserting the logout is successful
        //strategy : if the current url contains auth then it means user is back on the login page
        Assert.assertTrue(driver.getCurrentUrl().contains("auth"));
        //strategy : if login h5 element is displayed then it means user is back on the login page
        //.isDisplayed() returns TRUE if elements is displayed
        //
        Assert.assertTrue(driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']")).isDisplayed());

        //My Way
        Assert.assertTrue(driver.getCurrentUrl().contains("login"));



    }


}
