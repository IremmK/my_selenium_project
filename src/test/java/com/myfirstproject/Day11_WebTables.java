package com.myfirstproject;

import com.myfirstproject.utilities.TestBase;
import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Day11_WebTables extends TestBase {
    @Test
    public void printTableMethodTest (){
        //https://the-internet.herokuapp.com/tables
        driver.get("https://the-internet.herokuapp.com/tables");

        //Create a class: WebTables
        extentTest.pass("*********PRINT ENTIRE TABLE***********");

        //Task 1 : Print the entire table
        String entireTable = driver.findElement(By.xpath("//table[@id='table1']")).getText();
        System.out.println(entireTable);

        //ALTERNATIVELY
        List<WebElement> elements = driver.findElements(By.xpath("//table[@id='table1']//td"));
        for(WebElement eachData : elements){
            System.out.println(eachData.getText());
            extentTest.pass(eachData.getText());
        }

        //GET SPECIFIC INDEX ELEMENTS
        System.out.println( "6TH DATA IN THE TABLE =>>>" +elements.get(5).getText());



    }

    @Test
    public void printAllRowsTest (){
        //Task 2 : Print All Rows
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        int rowNum = 1;
        for(WebElement eachRow : allRows){
            System.out.println(rowNum + " : " + eachRow.getText());
            rowNum++;
        }
        System.out.println("2ND ROW DATA : " + allRows.get(1).getText());
        //Task 3 : Print Last row data only
        System.out.println("LAST ROW DATA : " + allRows.get(allRows.size()-1).getText());


    }
    @Test
    public void printColumns (){
        //Task 4 : Print column 5 data in the table body
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> column5Data = driver.findElements(By.xpath("//table[@id='table1']//tr//td[5]"));
        int colNum = 1;
        for(WebElement eachData : column5Data){
            System.out.println(colNum + " : " + eachData.getText());
            extentTest.pass(eachData.getText());
            colNum++;
        }
        System.out.println("COLUMN 5 DATA : "+column5Data);

    }
    //REST IS YOUR HOMEWORK
    //Task 5 : Write a method that accepts 2 parameters
    //Parameter 1 = row number
    //Parameter 2 = column number
    //printData(2,3);  => prints data in 2nd row 3rd column
    static String data;
    public static String printData (int row , int column){
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> allColumns = driver.findElements(By.xpath("//table[@id='table1']//tr//td"));
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='table1']//tr"));

        if(allRows.get(row).getText().equals(allColumns.get(column).getText())){
            data =allRows.get(row).getText() ;
        }
        return data;




    }

    public static void main(String[] args) {
        System.out.println(printData(2, 3));
    }
}
