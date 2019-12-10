package com.qq.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
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

    /**
     * 获取Excel中所有测试用例
     *
     * @param source excel文件路径
     * @return
     */
    public static Map<String, List<Map<String, String>>> getAllCases(String source) {
        Map<String, List<Map<String, String>>> ret = new HashMap<>();
        try {
            open(source);
            int numberOfSheets = wb.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                Sheet sheet = wb.getSheetAt(i);
                if (sheet != null) {
                    List<Map<String, String>> sheetData = getSheetData(sheet);
                    if (sheetData != null)
                        ret.put(sheet.getSheetName(), sheetData);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();//关闭资源
            return ret;
        }
    }

    /**
     * 获取Excel中指定Sheet中的用例
     *
     * @param source    Excel文件路径
     * @param sheetName Sheet名
     * @return
     */
    public static List<Map<String, String>> getCases(String source, String sheetName) {
        List<Map<String, String>> ret = new ArrayList<>();
        try {
            open(source);
            Sheet sheet = wb.getSheet(sheetName);
            ret = getSheetData(sheet);
        } catch (IOException e) {
            //处理异常
            e.printStackTrace();
        } finally {
            close();
            return ret;
        }
    }


    private static void open(String source) throws IOException {
        InputStream in = new FileInputStream(source);
        bis = new BufferedInputStream(in);//使用缓冲字节流，提升效率
        wb = XSSFWorkbookFactory.create(bis);
    }

    private static void close() {
        if (null != wb) {
            try {
                wb.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<Map<String, String>> getSheetData(Sheet sheet) {
        List<Map<String, String>> ret = new ArrayList<>();
        int rowsNum = sheet.getLastRowNum();//最后一行（基于0）
        Row rowHead = sheet.getRow(0);//第一行为表头，其余行为具体用例
        short lastCellNum = rowHead.getLastCellNum();//最后一列（基于1）
        for (int rowNum = 1; rowNum <= rowsNum; rowNum++) {
            Map<String, String> rowData = new HashMap<>();
            Row row = sheet.getRow(rowNum);
            for (int cellNum = 0; cellNum < lastCellNum; cellNum++) {
                //row.getCell(cellNum);//getCell传入逻辑行号，基于0
                rowData.put(rowHead.getCell(cellNum).getStringCellValue(), row.getCell(cellNum).getStringCellValue());
            }
            ret.add(rowData);
        }
        return ret;
    }
}
