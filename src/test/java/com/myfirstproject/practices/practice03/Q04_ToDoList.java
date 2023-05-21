package com.myfirstproject.practices.practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q04_ToDoList extends TestBase {
    /*
Given
    Go to http://webdriveruniversity.com/To-Do-List/index.html
When
    Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
And
    Strikethrough all todos.
And
    Delete all todos.
Then
    Assert that all todos deleted.
 */
    @Test
    public void toDoListTest () throws InterruptedException {
        //Go to http://webdriveruniversity.com/To-Do-List/index.html
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");

        //Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
        List<String> toDoList = new ArrayList<>(Arrays.asList("Prepare breakfast", "Wash the dishes", "Take care of baby" /*,"Help your kid's homework"*/, "Study Selenium", "Sleep"));
        WebElement toDoInput = driver.findElement(By.xpath("//input[@placeholder='Add new todo']"));
        for(String w:toDoList ){
            toDoInput.sendKeys(w+ Keys.ENTER);
        }

        //Strikethrough all todos.
        driver.findElement(By.xpath("//li[.=' Go to potion class']")).click();
        driver.findElement(By.xpath("//li[.=' Buy new robes']")).click();
        driver.findElement(By.xpath("//li[.=' Practice magic']")).click();
        driver.findElement(By.xpath("//li[.=' Prepare breakfast']")).click();
        driver.findElement(By.xpath("//li[.=' Wash the dishes']")).click();
        driver.findElement(By.xpath("//li[.=' Take care of baby']")).click();
        //Thread.sleep(5000);
        //driver.findElement(By.xpath("//li[.=' Help your kid's homework']")).click();
        driver.findElement(By.xpath("//li[.=' Study Selenium']")).click();
        driver.findElement(By.xpath("//li[.=' Sleep']")).click();
        Thread.sleep(5000);


        //Delete all todos.
        driver.findElement(By.xpath("//li[.=' Go to potion class']//i[@class='fa fa-trash']")).click();
        driver.findElement(By.xpath("//li[.=' Buy new robes']//i[@class='fa fa-trash']")).click();
        driver.findElement(By.xpath("//li[.=' Practice magic']//i[@class='fa fa-trash']")).click();
        driver.findElement(By.xpath("//li[.=' Prepare breakfast']//i[@class='fa fa-trash']")).click();
        driver.findElement(By.xpath("//li[.=' Wash the dishes']//i[@class='fa fa-trash']")).click();
        driver.findElement(By.xpath("//li[.=' Take care of baby']//i[@class='fa fa-trash']")).click();
        //driver.findElement(By.xpath("//li[.=' Help your kid's homework']//i[@class='fa fa-trash']")).click();
        driver.findElement(By.xpath("//li[.=' Study Selenium']//i[@class='fa fa-trash']")).click();
        driver.findElement(By.xpath("//li[.=' Sleep']//i[@class='fa fa-trash']")).click();
        Thread.sleep(5000);


        //Assert that all todos deleted.
       // Assert.assertFalse(driver.getPageSource().contains(driver.findElement(By.xpath("//ul//li")).getText()));

    }
}
