package com.myfirstproject.practices.practice03;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Q03_AddDeleteElements extends TestBase {
    /*
Given
    Go to http://the-internet.herokuapp.com/add_remove_elements/
When
    Click on the "Add Element" button more than times
And
    Click on the "Delete" button 20 times
Then
    Assert that 20 buttons were deleted.
  */
    @Test
    public void addDeleteElementsTest (){
        //Go to http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

        // Click on the "Add Element" button more than 20 times
        WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));
        for(int i=0;i<30;i++){
            addElement.click();
        }

        //Click on the "Delete" button 20 times
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//button[.='Delete']"));
        int sizeBeforeDelete = deleteButtons.size();
        for (int i=0;i<20;i++){
            deleteButtons.get(i).click();
            //deleteButtons.remove(i);-->My way but teacher didn't use that way, but that is easy.
        }
        //Assert that 20 buttons were deleted.
        //Assert.assertEquals(80,deleteButtons.size());-->My way
        int sizeAfterDelete = driver.findElements(By.xpath("//button[.='Delete']")).size();
        Assert.assertEquals(sizeBeforeDelete-20,sizeAfterDelete);
    }
}
