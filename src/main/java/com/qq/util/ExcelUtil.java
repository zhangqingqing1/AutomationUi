package com.qq.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lu
 * @date 2019/12/10 9:08
 */
public class ExcelUtil {
    public static void main(String[] args) throws IOException {
        String excelPath = ExcelUtil.class.getResource("/BaiduTest.xlsx").getPath();
        getCases(excelPath, "searchTest");
    }

    private static Workbook wb;
    private static BufferedInputStream bis;

    public static List<Map<String, List<String>>> getAllCases(String source) throws IOException {
        open(source);
        /**
         * 业务实现
         *
         *
         *
         */
        close();
        return null;
    }

    public static List<String> getCases(String source, String sheetName) throws IOException {
        open(source);
        Sheet sheet = wb.getSheet(sheetName);
        int rowsNum = sheet.getLastRowNum();//最后一行（基于0）
        //第一行为表头，其余行为具体用例
        Row row0 = sheet.getRow(0);
        short lastCellNum = row0.getLastCellNum();//最后一列（基于1）
        Map<String, String> cas = new LinkedHashMap<>();
        for (int rowNum = 1; rowNum <= rowsNum; rowNum++) {
            Row row = sheet.getRow(rowNum);
            for (int cellNum = 0; cellNum < lastCellNum; cellNum++) {
                Cell cell = row.getCell(cellNum);//getCell传入逻辑行号，基于0
            }
        }
        close();
        return null;
    }

    private static void open(String source) throws IOException {
        InputStream in = new FileInputStream(source);
        bis = new BufferedInputStream(in);
        wb = XSSFWorkbookFactory.create(bis);
    }

    private static void close() throws IOException {
        if (null != wb) wb.close();
    }
}
