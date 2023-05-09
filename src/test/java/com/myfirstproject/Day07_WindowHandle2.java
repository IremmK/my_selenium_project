package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;

public class Day07_WindowHandle2 extends TestBase {
    @Test
    public void newTabTest () throws InterruptedException {
        //amazon title test
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        String amazonWindowHandle = driver.getWindowHandle();

        //linkedin title test
        driver.switchTo().newWindow(WindowType.TAB);//Create a new tab and switch to it
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        String linkedInWindowHandle = driver.getWindowHandle();

        //ebay title test
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.ebay.com");
        Assert.assertTrue(driver.getTitle().contains("eBay"));
        String ebayWindowHandle = driver.getWindowHandle();

        //Switch to LinkedIn
        driver.switchTo().window(linkedInWindowHandle);
        Thread.sleep(5000);

        //Switch to amazon
        driver.switchTo().window(amazonWindowHandle);
        Thread.sleep(5000);
    }

    @Test
    public void newWindowTest () throws InterruptedException {
        //amazon title test
        driver.get("https://www.amazon.com");
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        String amazonWindowHandle = driver.getWindowHandle();

        //linkedin title test
        driver.switchTo().newWindow(WindowType.WINDOW);//Create a new window and switch to it
        driver.get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        String linkedInWindowHandle = driver.getWindowHandle();

        //ebay title test
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.ebay.com");
        Assert.assertTrue(driver.getTitle().contains("eBay"));
        String ebayWindowHandle = driver.getWindowHandle();

        //Switch to LinkedIn
        driver.switchTo().window(linkedInWindowHandle);
        Thread.sleep(5000);

        //Switch to amazon
        driver.switchTo().window(amazonWindowHandle);
        Thread.sleep(5000);

    }
}
