package com.myfirstproject;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Day15_ReadExcel {

    @Test
    public void readExcel () throws IOException {
        String path = "resources/Capitals.xlsx";
        //open the file
        FileInputStream fileInputStream = new FileInputStream(path);
        //Open the workbook using fileInputStream
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        //Open the first worksheet
        Sheet sheet1 = workbook.getSheet("sheet1");
        //workbook.getSheet(0);//ALTERNATIVELY GETTING SHEET1 BY INDEX
        //Go to first row
        Row row1 = sheet1.getRow(0);//index starts with 0
        //Go to first cell on that first row and print
        Cell cell1 = row1.getCell(0);
        System.out.println(cell1);
        //Go to second cell on that first row and print
        Cell cell2 = row1.getCell(1);
        System.out.println(cell2);
        //Go to 2nd row first cll and assert if data equal to USA
        Row row2 = sheet1.getRow(1);
        Cell row2cell1 = row2.getCell(0);
        Assert.assertEquals("USA",row2cell1.toString());
        //Go to 3rd row 2nd cell-chain the row and cell
        Row row3 = sheet1.getRow(2);
        Cell row3cell2 = row3.getCell(1);
        System.out.println(row3cell2);
        //Find the number of row
        int numOfRow = sheet1.getLastRowNum()+1;//index starts at 0
        System.out.println(numOfRow);
        //Find the number of used row
        int usedRowCount = sheet1.getPhysicalNumberOfRows();
        System.out.println(usedRowCount);//index starts at 1
        //Print country, capital key value pairs as map object
        ///create a map, and use a loop to add all countries as key, and capitals as value
        Map<String,String> countryCapital = new HashMap<>();




    }

}
