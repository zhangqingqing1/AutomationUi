package com.qq.util;

import org.apache.poi.ss.usermodel.*;

import java.io.File;

public class ExcelUtil_wxj {
    public static void main(String[] args) {
        try{
            Workbook workbook = WorkbookFactory.create(new File(".\\src\\main\\resources\\BaiduTest.xlsx"));
            @SuppressWarnings("resource")
            //加载sheet
            Sheet sh1 = workbook.getSheetAt(0);

            for(int i=1;i<sh1.getPhysicalNumberOfRows();i++){
                for (int j=1;j<sh1.getRow(i).getPhysicalNumberOfCells();j++){
                    System.out.print(sh1.getRow(i).getCell(j).getStringCellValue()+"\t");
                }
                System.out.println();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
