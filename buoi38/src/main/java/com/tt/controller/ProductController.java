package com.tt.controller;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

@RestController
public class ProductController {

    @PostMapping("product")
    public ResponseEntity<?> upFile(@RequestParam MultipartFile multipartFile) {

        try{
            XSSFWorkbook workbook = new XSSFWorkbook(multipartFile.getInputStream());

            XSSFSheet sheet = workbook.getSheetAt(0);
            System.out.println(sheet.getPhysicalNumberOfRows());

            XSSFSheet newSheet = workbook.createSheet("Sheet3");
//
//            //Create row object
//            XSSFRow row;
//
//            //This data needs to be written (Object[])
//            Map< String, Object[] > empinfo = new TreeMap<>();
//            empinfo.put( "1", new Object[] { "EMP ID", "EMP NAME", "DESIGNATION" });
//            empinfo.put( "2", new Object[] { "tp01", "Gopal", "Technical Manager" });
//
//            //Iterate over data and write to sheet
//            Set< String > keyid = empinfo.keySet();
//            int rowid = 0;
//
//            for (String key : keyid) {
//                row = newSheet.createRow(rowid++);
//                Object [] objectArr = empinfo.get(key);
//                int cellid = 0;
//
//                for (Object obj : objectArr) {
//                    Cell cell = row.createCell(cellid++);
//                    cell.setCellValue((String)obj);
//                }
//            }
//            //Write the workbook in file system
//            FileOutputStream out = new FileOutputStream(new File("Writesheet.xlsx"));
//            workbook.write(out);
//            out.close();
//            System.out.println("Writesheet.xlsx written successfully");

            XSSFRow row;
            row = newSheet.createRow(0);
            Cell cell = row.createCell(0);
            cell.setCellValue("abc");

            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("Writesheet.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Writesheet.xlsx written successfully");
        }catch (Exception ex) {
            System.out.println(ex);
        }
        return new ResponseEntity<>("Success", HttpStatus.OK);
    }
}
