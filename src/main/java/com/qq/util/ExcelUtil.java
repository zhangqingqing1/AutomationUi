package com.qq.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: lu
 * @date 2019/12/10 9:08
 */
public class ExcelUtil {
    private static Workbook wb;
    private static BufferedInputStream bis;

    public static List<Map<String, List<String>>> getAllCases(String source) {

    }

    public static List<String> getCasesBySheet(String source, String sheetName) throws IOException {
        open(source);
        Sheet sheet = wb.getSheet(sheetName);
        sheet.row
    }

    private static void open(String source) throws IOException {
        InputStream in = new FileInputStream(source);
        bis = new BufferedInputStream(in);
        wb = XSSFWorkbookFactory.create(bis);
    }
}
