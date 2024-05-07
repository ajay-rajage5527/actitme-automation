package ExcelHandling;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteCodeINExcel2 {
    Workbook workbook;
    Sheet sheet;
    @Test
    public void writeCode() throws IOException {
        File file=new File("D:\\Actitime\\TestData.xlsx");
        String fileName=file.getName();
        String extention=fileName.substring(fileName.indexOf(".")+1);
        System.out.println(extention);
        if(extention.equals("xlsx")){
            workbook=new XSSFWorkbook();
        }else if(extention.equals("xls")){
            workbook=new HSSFWorkbook();
        }
        if(workbook.getSheet("Empoyees")!=null){
            sheet=workbook.getSheet("Empoyees");
        } else{
           sheet= workbook.createSheet("Empoyees");
        }
         for(int i=0;i<10;i++){
             Row row=sheet.createRow(i);
             for(int j=0;j<2;j++){
                Cell cell = row.createCell(j);
                if(j==0){
                    cell.setCellValue("EmpId"+i);
                }else{
                    cell.setCellValue("Ename"+i);
                }
             }
         }
        FileOutputStream outputStream=new FileOutputStream(file);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
