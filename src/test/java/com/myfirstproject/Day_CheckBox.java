package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day_CheckBox {
    WebDriver driver;
    @Before
    public void setUp(){
        //this method will be use for pre-conditions
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=checkboxes");
    }
    /*
    Create a class : CheckBox
Create test method and complete the following task.
Go to https://testcenter.techproeducation.com/index.php?page=checkboxes
Locate the elements of checkboxes
Then click on checkbox1 if box is not selected
Then click on checkbox2 if box is not selected
Then verify that checkbox1 is checked.
     */
    @Test
    public void checkBoxTest (){
        //Then click on checkbox1 if box is not selected
        //locating the element by xpath
        WebElement checkBox1 =driver.findElement(By.xpath("//input[@id='box1']"));
        //is checkbox1 is already selected
        boolean isCheckbox1Selected = checkBox1.isSelected();
        //! = NOT
        if(!isCheckbox1Selected){
            checkBox1.click();
        }
        //Then verify checkbox1 is selected
        Assert.assertTrue(checkBox1.isSelected());

        //Then click on checkbox2 if box is not selected
        WebElement checkBox2 = driver.findElement(By.xpath("//input[@id='box2']"));
        //is checkbox2 already selected
        boolean isCheckbox2Selected = checkBox2.isSelected();
        //!= NOT
        if(!isCheckbox2Selected){
            checkBox2.click();
        }
    }
    @After
    public void tearDown (){
        driver.quit();
    }
}
