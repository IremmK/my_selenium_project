package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Day12_JSExecutor extends TestBase {
    @Test
    public void scrollIntoViewTest () throws IOException {
        driver.get("https://www.amazon.com");
        //Location element amazon page
        WebElement footer = driver.findElement(By.xpath("//div[@id='navFooter']//tbody"));
        //scroll into that element
        scrollIntoViewJS(footer);
        //take a screenshot of the page
        takeScreenshotOfTheEntirePage();
        //Locate the search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        //and scroll into that element
        scrollIntoViewJS(searchBox);
        // then verify the element is displayed
        Assert.assertTrue(searchBox.isDisplayed());
        // then take screenshot
        takeScreenshotOfTheEntirePage();
    }

    @Test
    public void scrollAllTheWayUpAndDown () throws IOException, InterruptedException {
        driver.get("https://www.amazon.com");
        //scroll all the way down and take a screenshot of the page
        scrollAllTheWayDownJS();
        takeScreenshotOfTheEntirePage();
        Thread.sleep(3000);
        scrollAllTheWayUpJS();
        takeScreenshotOfTheEntirePage();

    }
    @Test
    public void clickByJSTest () throws InterruptedException, IOException {
        //search porcelain tea set on amazon
        driver.get("https://www.amazon.com");
        //locating search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        //typing porcelain tea set
        searchBox.sendKeys("porcelain tea set");
        Thread.sleep(5000);
        takeScreenshotOfTheEntirePage();
        //locating search button and clicking on it with js executor
        WebElement searchIcon = driver.findElement(By.id("nav-search-submit-button"));
        clicksByJS(searchIcon);//JS CLICK
        takeScreenshotOfTheEntirePage();
    }

    @Test
    public void locateElementByJSTest () throws InterruptedException {
        //search porcelain tea set on amazon
        driver.get("https://www.amazon.com");
        //locating search box using js executor
        WebElement searchBox = locateElementsByJS("twotabsearchtextbox");
        searchBox.sendKeys("porcelain tea set");
        Thread.sleep(5000);
        //locating search box icon using js executor
        WebElement searchIcon = locateElementsByJS("nav-search-submit-button");
        clicksByJS(searchIcon);

    }
    @Test
    public void typeWithJS (){
        //search porcelain tea set on amazon
        driver.get("https://www.amazon.com");
        //locating search box using js executor
        WebElement searchBox = locateElementsByJS("twotabsearchtextbox");
        //type the search box using JS
        setValueByJS(searchBox,"porcelain tea set");
        //locating search box icon using js executor
        WebElement searchIcon = locateElementsByJS("nav-search-submit-button");
        clicksByJS(searchIcon);
    }


}
