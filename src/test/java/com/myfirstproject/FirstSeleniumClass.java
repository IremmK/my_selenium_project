package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstSeleniumClass {

    public static void main(String[] args) {

        //this is one way to create an automation script
        //We will not use main method later on
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");//LATER WE WILL NOT USE THIS METHOD

        //Create driver
        WebDriver driver = new ChromeDriver();

        //navigate to techpro
        driver.get("https://techproeducation.com");

    }
}
