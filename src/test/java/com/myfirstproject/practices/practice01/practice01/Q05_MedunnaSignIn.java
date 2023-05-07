package com.myfirstproject.practices.practice01.practice01;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Q05_MedunnaSignIn extends TestBase {
    @Test
    public void medunnaSignInTest (){
        //Go to https://www.medunna.com/
        driver.get("https://www.medunna.com/");

        //click on profile icon and then select the sign in option
        driver.findElement(By.xpath("//a[@class='d-flex align-items-center dropdown-toggle nav-link']")).click();
        driver.findElement(By.linkText("Sign in")).sendKeys(Keys.ENTER);

        //Enter mark_twain username
        driver.findElement(By.name("username")).sendKeys("mark_twain");

        //Enter Mark.123 password
        driver.findElement(By.name("password")).sendKeys("Mark.123");

        //click on remember me
        driver.findElement(By.id("rememberMe")).click();

        //click on sign in button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Assert that you signed in
        WebElement name = driver.findElement(By.xpath("//span[.='Mark Twain']"));
        Assert.assertTrue(name.getText().contains("Mark Twain"));
        System.out.println(name.getText());
        //Homework...

    }
}
