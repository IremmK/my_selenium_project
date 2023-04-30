package com.myfirstproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_Navigations {

    public static void main(String[] args) {
        //1.Set up
        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");

        //2.Create the driver object
        WebDriver driver = new ChromeDriver();

        //3.Now that we have our driver instance, we can start creating our test script
        //Maximize the window
        driver.manage().window().maximize();

        //Open google home page https://www.walmart.com/
        driver.get("https://www.walmart.com/");

        //On the same class, Navigate to amazon home page "https://www.amazon.com/"
        driver.navigate().to("https://www.amazon.com/");//Alternative way of navigating to a website

        //Navigate back to google
        driver.navigate().back();

        //Navigate forward to amazon
        driver.navigate().forward();

        //Refresh the page
        driver.navigate().refresh();

        //Close/Quit the browser
        //There are two ways to close the browser close() or quit() we shouldn't use both
        //driver.close();
        driver.quit();

        /*
        *****What is the difference between get() and navigate().to() functions?
        * Similarities : Both let you go to a page
        * get() is moe common that navigate().to() and It is easy to read
        * get() accepts only Strings as URL, but navigate().to() accept both string and URL
        * navigate() has more options such as to(), back(), forward(), refresh()

        *****What i the difference between close() and quit()?
        * close() closed only the last active window
        * quit() closes all active window
        * recommendation is use quit() at the end of the last test case
         */



    }


}
