package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Day02_WebDriverManager {
    public static void main(String[] args) {
        //WITHOUT WEBDRIVER MANAGER

        //TESTING ON CHROME
        //System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");//chrome setup
        //WebDriver chrome = new ChromeDriver();

        //TESTING ON FIREFOX
        //System.setProperty("webdriver.firefox.driver","./driver/firefoxdriver.exe");//firefox setUp
        //WebDriver firefox = new FirefoxDriver();

        //TESTING ON EDGE
        //System.setProperty("webdriver.edge.driver","./driver/edgedriver.exe");//edge setup
        //WebDriver edge = new EdgeDriver();

        //WITH WEBDRIVER MANAGER

        WebDriverManager.chromedriver().setup();//chrome setup
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");

        //Firefox Setup
//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//        driver.get("https://www.techproeducation.com");




    }
}
