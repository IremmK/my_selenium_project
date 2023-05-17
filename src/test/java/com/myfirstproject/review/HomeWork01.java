package com.myfirstproject.review;
//Task01:
    /*
    Go to ebay page
    Click on electronics section
    Click on all the images with a Width of 225 and a Length of 225
    Print the page title of each page
    Close the page
     */

//Task02:
    /*
    Create and Maximize the driver with the BeforeClass method and put implicit wait for 15 seconds
    Go to http://www.google.com in the before method
    With 3 different test methods:
     -Type "Desktop" in the search box and print the number of results
     -Type "Smartphone" in the search box and print the number of results
     -Type "Laptop" in the search box and print the number of results
    NOTE: Print the result numbers in After method
    Close driver with AfterClass method
     */

//Task03:
    /*
    Go to https://amazon.com
    Print all the options in the 'Departments' dropdown on the left side of the search box
    Search for each first five options and print titles
    */

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomeWork01 extends TestBase {
    /*
    Go to ebay page
    Click on electronics section
    Click on all the images with a Width of 225 and a Length of 225
    Print the page title of each page
    Close the page
     */
    @Test
    public void ebayTest (){
        driver.get("https://www.ebay.com/");
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/ul/li[8]/div[2]/a[1]")).click();
        List<WebElement> imgs = driver.findElements(By.xpath("//img[@width='225']"));
        for(WebElement eachData : imgs){
            System.out.print(eachData.getText());
        }



    }

    @Test
    public void googleTest (){
//        Create and Maximize the driver with the BeforeClass method and put implicit wait for 15 seconds
//        Go to http://www.google.com in the before method
        driver.get("http://www.google.com");

//        With 3 different test methods:
//        -Type "Desktop" in the search box and print the number of results
        driver.findElement(By.id("APjFqb")).sendKeys("Desktop");

//        -Type "Smartphone" in the search box and print the number of results
//        -Type "Laptop" in the search box and print the number of results
//        NOTE: Print the result numbers in After method
//        Close driver with AfterClass method

    }

    @Test
    public void amazonTest (){
        //Go to https://amazon.com
        driver.get("");
        //Print all the options in the 'Departments' dropdown on the left side of the search box
        
        //Search for each first five options and print titles
    }

}
