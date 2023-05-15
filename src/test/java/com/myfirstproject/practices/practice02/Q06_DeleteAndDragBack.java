package com.myfirstproject.practices.practice02;

import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;

public class Q06_DeleteAndDragBack extends TestBase {
    /*
 Go to URL : https://www.globalsqa.com/demo-site/draganddrop/
 Delete images by clicking delete buttons
 Recycle images by clicking Recycle buttons
 Delete images by drag and drop
 Recycle images by drag and drop
*/
    @Test
    public void deleteAndDragBackTest () throws InterruptedException {
        //Go to URL : https://www.globalsqa.com/demo-site/draganddrop/
        driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
        //Switch to iframe
        WebElement iframe = driver.findElement(By.xpath("//iframe[@data-src='../../demoSite/practice/droppable/photo-manager.html']"));
        driver.switchTo().frame(iframe);

        //Delete images by clicking delete buttons
        //Locate delete buttons
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//a[.='Delete image']"));
        System.out.println(deleteButtons.size());
//        for(WebElement w : deleteButtons){
//            Thread.sleep(1000);
//            w.click();
//        }

        deleteButtons.forEach(WebElement::click);//Lambda is recommended

        // Recycle images by clicking Recycle buttons
        Thread.sleep(1000);
        List <WebElement> recycleButtons = driver.findElements(By.xpath("//a[.='Recycle image']"));
        System.out.println(recycleButtons.size());
        recycleButtons.forEach(WebElement::click);

        // Delete images by drag and drop
        List<WebElement> images = driver.findElements(By.xpath("//ul[@id='gallery']/li"));

        WebElement trash = driver.findElement(By.id("trash"));
        Actions actions = new Actions(driver);

        images.forEach(t->actions.pause(500).dragAndDrop(t,trash).perform());


        // Recycle images by drag and drop.
        WebElement recycle = driver.findElement(By.id("gallery"));
        images.forEach(t->actions.pause(500).dragAndDrop(t,recycle).perform());

    }
}
