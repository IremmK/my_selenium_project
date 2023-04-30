package com.myfirstproject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.bind.SchemaOutputResolver;
import java.time.Duration;

public class Day02_VerifyTitleTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();//chrome setup
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));//implicit Wait
        driver.manage().window().maximize();


        //Create a new class: VerifyTitleTest
        //Navigate to techproeducation.com
        //Verify if page title "TechPro Education | Online IT Courses & Bootcamps"

        driver.get("https://www.techproeducation.com");
        String title = driver.getTitle();//returns the title of the page as string
        if(title.equals("Techpro Education | Online It Courses & Bootcamps")){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("EXPECTED TITLE : Techpro Education | Online It Courses & Bootcamps");
            System.out.println("ACTUAL TITLE : "+title);
        }
        driver.quit();
    }
}
