package com.orangehrm.automation;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelHandling {
    FileInputStream inputStream;
    Workbook workbook;
    public Workbook getWorkBook(String filePath) throws IOException {
        File file=new File(filePath);
        String fileName=file.getName();
       String extention= fileName.substring(fileName.indexOf(".")+1);
       System.out.println(extention);
        inputStream=new FileInputStream(file);
        if(extention.equals("xlsx")){
            workbook=new XSSFWorkbook(inputStream);
        }
        else if(extention.equals("xls")){
            workbook=new HSSFWorkbook(inputStream);
        }
        return workbook;
    }
    @DataProvider
    public Object[][] getExcelData() throws IOException {
        Workbook workbook1 = getWorkBook("D:\\Actitime\\TestData.xlsx");
        Sheet sheet = workbook1.getSheetAt(0);
        int totalRows = sheet.getPhysicalNumberOfRows();
        System.out.println("total rows" + totalRows);
        Row row;
        row = sheet.getRow(0);
        int totalColumns = row.getPhysicalNumberOfCells();
        System.out.println("total columns" + totalColumns);
        Object[][] data = new Object[totalRows - 1][totalColumns];
        for (int i = 1; i < totalRows; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < totalColumns; j++) {
                Cell cell = row.getCell(j);
                Object var = null;
                if (cell.getCellType() != null) {
                    switch (cell.getCellType()) {
                        case STRING:

                    }
                }
            }
        }
        return data;
    }

}
