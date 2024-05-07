package com.amazon;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExelHandling {
    public static void main(String[] args) throws IOException {
        //from file
        FileInputStream inputStream=new FileInputStream("D:\\Actitime\\TestData.xlsx");
        //TO workbook
        Workbook workbook =new XSSFWorkbook(inputStream);
        //To Sheet
        Sheet sheet=workbook.getSheetAt(0);
        //sheet to number of column
        int totalRows=sheet.getPhysicalNumberOfRows();
        System.out.println(totalRows);
        Row row;
        row=sheet.getRow(0);
       int totalColumns= row.getPhysicalNumberOfCells();
        System.out.println(totalColumns);
        for(int i=1;i<totalRows;i++){
            row=sheet.getRow(i);
            for(int j=0;j<totalColumns;j++){
                Cell cell=row.getCell(j);
                String val=cell.getStringCellValue();
                System.out.print(val+" ");
            }
            System.out.println();
        }
         workbook.close();
        inputStream.close();


    }
}