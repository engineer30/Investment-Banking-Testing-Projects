package com.investmentbanking.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    public static String getCellData(String filePath, String sheetName,
                                     int rowNumber, int columnNumber) {

        String cellData = "";

        try {
            FileInputStream file = new FileInputStream(filePath);

            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet = workbook.getSheet(sheetName);

            cellData = sheet.getRow(rowNumber)
                            .getCell(columnNumber)
                            .toString();

            workbook.close();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cellData;
    }
}
