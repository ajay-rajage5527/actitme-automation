package com.amazon;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class SameExcelHandlingPractice {
    FileInputStream inputStream;
    Workbook workbook;

    public Workbook getworkBook(String filepath) throws IOException {
        File file = new File(filepath);
        String fileName = file.getName();
        String extension = fileName.substring(fileName.indexOf(".") + 1);
        System.out.println(extension);
        inputStream = new FileInputStream(file);
        if (extension.equals("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (extension.equals("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        }
        return workbook;
    }

@DataProvider
    public Object[][] getExcelData() throws IOException {
        Workbook workbook = getworkBook("D:\\Actitime\\TestData.xlsx");
        Sheet sheet = workbook.getSheetAt(0);
        int totalRows = sheet.getPhysicalNumberOfRows();
        System.out.println(totalRows);
        Row row;
        row = sheet.getRow(0);
        int totalColumn = row.getPhysicalNumberOfCells();
        System.out.println(totalColumn);
        Object[][] data = new Object[totalRows - 1][totalColumn];
        for (int i = 1; i < totalRows; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < totalColumn; j++) {
                Cell cell = row.getCell(j);
                Object var = null;
                if (cell.getCellType()!= null) {
                    switch (cell.getCellType()) {
                        case STRING :
                            var=cell.getStringCellValue();
                            break;
                        case BOOLEAN:
                            var=cell.getBooleanCellValue();
                            break;
                        case BLANK:
                            break;
                        case NUMERIC:
                            var=cell.getNumericCellValue();
                            break;
                    }
                }
                data[i - 1][j] = var;
                System.out.println(var + " ");
            }
        }
        System.out.println();
        return data;
    }


    public void closeInstances() throws IOException {
        workbook.close();
        inputStream.close();
    }
    @Test(dataProvider = "getExcelData")
    public void verifyExcelData(Object var1,Object var2){
        System.out.println(var1+" "+var2);
    }
    @AfterClass
    public void tearDown() throws IOException {
        closeInstances();
    }
}


