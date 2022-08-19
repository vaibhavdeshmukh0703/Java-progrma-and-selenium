package com.example;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelDataProvier {

    @DataProvider(name = "dataSupplyer")
    public Object[][] dataSupplyer() {
        Object[][] object = null;
        FileInputStream fis = null;
        XSSFWorkbook xWorkbook = null;
        File file = null;
        try {
            file = new File("./Assets/Data.xlsx");
            System.out.println(file.exists());
            fis = new FileInputStream(file);
            xWorkbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = xWorkbook.getSheet("Sheet1");
            int sheetRows = sheet.getPhysicalNumberOfRows();// 4
            int coloum = sheet.getRow(0).getLastCellNum();// 3

            object = new Object[sheetRows - 1][coloum];
            System.out.println(object.length);

            for (int row = 0; row < sheetRows - 1; row++) {
                for (int cell = 0; cell < coloum; cell++) {
                    DataFormatter df = new DataFormatter();
                    object[row][cell] = df.formatCellValue(sheet.getRow(row + 1).getCell(cell));
                }
            }
            fis.close();
            xWorkbook.close();
            return object;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
        }

        return object;
    }
    public static void main(String[] args) {
        ExcelDataProvier edp = new ExcelDataProvier();
        edp.dataSupplyer();
    }
}
