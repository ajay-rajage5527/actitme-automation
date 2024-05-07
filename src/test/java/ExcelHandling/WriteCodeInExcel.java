package ExcelHandling;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.*;

public class WriteCodeInExcel {
    FileInputStream inputStream;
    Sheet sheet;
    Workbook workbook;
    @Test
    public void writeData() throws IOException {
        File file=new File("D:\\Actitime\\TestData.xlsx");
          String fileName=file.getName();
          String extension=fileName.substring(fileName.indexOf(".")+1);
          System.out.println(extension);
          inputStream=new FileInputStream(file);
          if(extension.equals("xlsx")){
                 workbook=new XSSFWorkbook(inputStream);
          }
          else if(extension.equals("xls")){
              workbook=new HSSFWorkbook(inputStream);
          }
          //check sheet present of name "cyber" if not present then create sheet of name cyber
        if(workbook.getSheet("cyber")!=null){
            sheet=workbook.getSheet("cyber");
        }
        else {
            sheet=workbook.createSheet("cyber");
        }
        for(int i=0;i<10;i++){
            Row row= sheet.createRow(i);
            for(int j=0;j<2;j++){
                Cell cell =row.createCell(j);
                if(j==0){
                    cell.setCellValue("selenium"+i);
                }else{
                    cell.setCellValue("api"+i);
                }
            }
        }
        sheet.createRow(10).createCell(0).setCellValue("ajay");
        sheet.createRow(11).createCell(1).setCellValue("api11");

        FileOutputStream outputStream=new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
