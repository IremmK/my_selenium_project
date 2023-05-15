package com.myfirstproject.review;

import com.myfirstproject.utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Q01 extends TestBase {
//    1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//            3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'New User Signup!' is visible
//6. Enter name and email address
//7. Click 'Signup' button
//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
//9. Fill details: Title, Name, Email, Password, Date of birth
//10. Select checkbox 'Sign up for our newsletter!'
//            11. Select checkbox 'Receive special offers from our partners!'
//            12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
//13. Click 'Create Account button'
//            14. Verify that 'ACCOUNT CREATED!' is visible
//15. Click 'Continue' button
//16. Verify that 'Logged in as username' is visible
//17. Click 'Delete Account' button
//18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
    @Test
    public void automationExerciseTest () throws InterruptedException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"));
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[.=' Signup / Login']")).click();
        //5. Verify 'New User Signup!' is visible
        String signUp = driver.findElement(By.xpath("//h2[.='New User Signup!']")).getText();
        Thread.sleep(3000);
        Assert.assertTrue(signUp.contains("New User Signup!"));

        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Irem");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("iremkaya55@gmail.com");
        Thread.sleep(5000);
        //7. Click 'Signup' button
        driver.findElement(By.xpath("//button[@data-qa='signup-button'] ")).click();
        Thread.sleep(3000);
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        String eai = driver.findElement(By.xpath("//b[.='Enter Account Information']")).getText();
        Thread.sleep(3000);
        Assert.assertTrue(eai.contains("ENTER ACCOUNT INFORMATION"));
        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender2")).click();
        driver.findElement(By.id("password")).sendKeys("564Irem.");
        //Date Of Birth------------------Fail
        driver.findElement(By.id("days")).sendKeys("20");
        driver.findElement(By.id("months")).sendKeys("May");
        driver.findElement(By.id("years")).sendKeys("1999");
        Thread.sleep(3000);


        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();

        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.id("optin")).click();

        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("Irem");
        driver.findElement(By.id("last_name")).sendKeys("Kaya");
        driver.findElement(By.id("company")).sendKeys("UTOR");
        driver.findElement(By.id("address1")).sendKeys("Mehmet Akif Ersoy mahallesi");
        driver.findElement(By.id("address2")).sendKeys("Esenyurt/ISTANBUL");
        driver.findElement(By.id("country")).sendKeys("United States");
        driver.findElement(By.id("state")).sendKeys("Florida");
        driver.findElement(By.id("city")).sendKeys("Miami");
        driver.findElement(By.id("zipcode")).sendKeys("34564");
        driver.findElement(By.id("mobile_number")).sendKeys("5438403870");

        //13. Click 'Create Account button'
        driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
        //14. Verify that 'ACCOUNT CREATED!' is visible
        String ac = driver.findElement(By.xpath("//b[.='Account Created!']")).getText();
        Assert.assertTrue(ac.contains("ACCOUNT CREATED!"));

        //15. Click 'Continue' button
        driver.findElement(By.xpath("//a[.='Continue']")).click();
        Thread.sleep(2000);
        //16. Verify that 'Logged in as username' is visible
        String irem = driver.findElement(By.xpath("//b[.='Irem']")).getText();
        Assert.assertTrue(irem.contains("Irem"));


        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        String ad = driver.findElement(By.xpath("//b[.='Account Deleted!']")).getText();
        Assert.assertTrue(ad.contains("ACCOUNT DELETED!"));






    }
}
