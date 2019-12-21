package com.qq.util;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExcelUtil_wxj {
    public static List<HashMap<String, String>> readExcel(File file,String sheetName) throws IOException {
        // 创建一个list 用来存储读取的内容
        List<HashMap<String, String>> dataList = new ArrayList<>();
        Workbook workbook = WorkbookFactory.create(file);
        @SuppressWarnings("resource")
        //加载sheet
        Sheet sh1 = workbook.getSheet(sheetName);
        for (int rowNum=1;rowNum<sh1.getPhysicalNumberOfRows(); rowNum++) {
            HashMap<String, String> line = new HashMap<>();
            // 创建一个数组用来存储每一列的值
            String[] str = new String[sh1.getRow(rowNum).getPhysicalNumberOfCells()];
            for (int cellNum=1;cellNum<sh1.getRow(rowNum).getPhysicalNumberOfCells(); cellNum++) {
                str[cellNum] = sh1.getRow(rowNum).getCell(cellNum).getStringCellValue();
                line.put(sh1.getRow(0).getCell(cellNum).getStringCellValue(), str[cellNum]);
            }
            dataList.add(line);
        }
        if(null != workbook){
            workbook.close();
        }
        return dataList;
    }
}
