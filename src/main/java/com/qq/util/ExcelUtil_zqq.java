package com.qq.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.*;

public class ExcelUtil_zqq {
    /**
     * 读取Excel文件内容
     *
     * @param fileName 要读取的Excel文件所在路径
     * @return 读取结果列表，读取失败时返回null
     */
    public static List<Map<String, List<String>>> readExcel(String fileName) {

        Workbook workbook = null;
        FileInputStream inputStream = null;

        try {
            ;
            // 获取Excel文件
            File excelFile = new File(fileName);
            if (!excelFile.exists()) {
                System.out.println("指定的Excel文件不存在！");
                return null;
            }

            // 获取Excel工作簿
            inputStream = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(inputStream);

            // 读取excel中的数据
            List<Map<String, List<String>>> resultDataList = parseExcel(workbook);

            return resultDataList;
        } catch (Exception e) {
            System.out.println("解析Excel失败，文件名：" + fileName + " 错误信息：" + e.getMessage());
            return null;
        } finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (Exception e) {
                System.out.println("关闭数据流出错！错误信息：" + e.getMessage());
                return null;
            }
        }
    }

    public static List<Map<String, List<String>>> readExcelBYsheetname(String fileName, String sheetname) {

        Workbook workbook = null;
        FileInputStream inputStream = null;

        try {
            ;
            // 获取Excel文件
            File excelFile = new File(fileName);
            if (!excelFile.exists()) {
                System.out.println("指定的Excel文件不存在！");
                return null;
            }

            // 获取Excel工作簿
            inputStream = new FileInputStream(excelFile);
            workbook = new XSSFWorkbook(inputStream);

            // 读取excel中的数据
            List<Map<String, List<String>>> maps = parseExcelBysheetname(workbook, sheetname);

            return maps;
        } catch (Exception e) {
            System.out.println("解析Excel失败，文件名：" + fileName + " 错误信息：" + e.getMessage());
            return null;
        } finally {
            try {
                if (null != workbook) {
                    workbook.close();
                }
                if (null != inputStream) {
                    inputStream.close();
                }
            } catch (Exception e) {
                System.out.println("关闭数据流出错！错误信息：" + e.getMessage());
                return null;
            }
        }
    }

    /**
     * 解析Excel数据
     *
     * @param workbook Excel工作簿对象
     * @return 解析结果
     */
    private static List<Map<String, List<String>>> parseExcel(Workbook workbook) {
        List<Map<String, List<String>>> resultDataList = new ArrayList<>();
        // 解析sheet
        for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
            Sheet sheet = workbook.getSheetAt(sheetNum);

            // 校验sheet是否合法
            if (sheet == null) {
                continue;
            }

            // 获取第一行数据
            int firstRowNum = sheet.getFirstRowNum();
            Row firstRow = sheet.getRow(firstRowNum);
            if (null == firstRow) {
                System.out.println("解析Excel失败，在第一行没有读取到任何数据");

            }

            // 解析每一行的数据，构造数据对象
            int rowStart = firstRowNum + 1;
            int rowEnd = sheet.getPhysicalNumberOfRows();
            for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
                Row row = sheet.getRow(rowNum);
                Map<String, List<String>> map = new HashMap<>();
                if (null == row) {
                    continue;
                }
                List<String> list1 = new ArrayList<>();
                for (int i = 1; i < row.getLastCellNum(); i++) {
                    list1.add(row.getCell(i).toString());
                }
                map.put(row.getCell(0).toString(), list1);
                if (null == map) {
                    System.out.println("第 " + row.getRowNum() + "行数据不合法，已忽略！");
                    continue;
                }
                resultDataList.add(map);
            }
        }

        return resultDataList;
    }

    /**
     * 解析Excel数据
     *
     * @param workbook Excel工作簿对象
     * @return 解析结果
     */
    private static List<Map<String, List<String>>> parseExcelBysheetname(Workbook workbook, String sheetname) {
        List<Map<String, List<String>>> list = new ArrayList<>();

        // 解析sheet
        Sheet sheet = workbook.getSheet(sheetname);
        // 获取第一行数据
        int firstRowNum = sheet.getFirstRowNum();
        Row firstRow = sheet.getRow(firstRowNum);
        if (null == firstRow) {
            System.out.println("解析Excel失败，在第一行没有读取到任何数据");

        }

        // 解析每一行的数据，构造数据对象
        int rowStart = firstRowNum + 1;
        int rowEnd = sheet.getPhysicalNumberOfRows();
        for (int rowNum = rowStart; rowNum < rowEnd; rowNum++) {
            Row row = sheet.getRow(rowNum);
            Map<String, List<String>> map = new HashMap<>();
            if (null == row) {
                continue;
            }
            List<String> list1 = new ArrayList<>();
            for (int i = 1; i < row.getLastCellNum(); i++) {
                list1.add(row.getCell(i).toString());
            }
            map.put(row.getCell(0).toString(), list1);

            if (null == map) {
                System.out.println("第 " + row.getRowNum() + "行数据不合法，已忽略！");
                continue;
            }
            list.add(map);
        }


        return list;
    }


}
