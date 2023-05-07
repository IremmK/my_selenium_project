package com.myfirstproject;

import com.github.javafaker.Faker;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomeWorkFaceBook extends TestBase {

    @Test
    public void facebookTest (){
    //Go to https:// www.facebook.com/
    driver.get("https://www.facebook.com/");

    //Click on Create an Account button


    //driver.findElement(By.xpath("//input[@name='firstname']")).click();
    // driver.findElement(By.linkText("Create new account")).click();
    Faker faker = new Faker();
    WebElement createNewAccount = driver.findElement(By.xpath("//*[ contains (text()=‘Create new account’ ) ]"));
    createNewAccount.click();
    WebElement firstname =driver.findElement(By.name("firstname"));
    firstname.sendKeys(faker.name().firstName());
    //System.out.println("firstName = " + firstName);
    //  System.out.println(faker.name().lastName());

    driver.findElement(By.name("lastname")).sendKeys(faker.name().lastName());
    String email = faker.internet().emailAddress();
    driver.findElement(By.name("reg_email__")).sendKeys(email);
    driver.findElement(By.name("reg_email_confirmation__")).sendKeys(email);
    //driver.findElement(By.name("reg_email__")).sendKeys(faker.phoneNumber().cellPhone());
    driver.findElement(By.name("reg_passwd__")).sendKeys(faker.number().digits(7));
    //driver.findElement(By.name("birthday_day")).sendKeys(faker.date().birthday());

    //Day
    WebElement day= driver.findElement(By.id("day"));
    Select options=new Select(day);
    options.selectByIndex(faker.date().birthday().getDate());

    //Month
    WebElement month= driver.findElement(By.id("month"));
    Select options1=new Select(month);
    options1.selectByIndex(faker.date().birthday().getMonth());
    //Year

    WebElement year= driver.findElement(By.id("year"));
    Select options2=new Select(year);
    options2.selectByIndex(faker.date().birthday().getYear());



    //Female
    if (!driver.findElement(By.xpath("//input[@value='1']")).isSelected()) {
        driver.findElement(By.xpath("//input[@value='1']")).click();

        //Male
        if (!driver.findElement(By.xpath("//input[@value='2']")).isSelected()) {
            driver.findElement(By.xpath("//input[@value='2']")).click();

        }
    }
    driver.findElement(By.xpath("//button[@name='websubmit']")).click();
}
}



