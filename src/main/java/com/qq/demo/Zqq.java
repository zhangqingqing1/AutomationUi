package com.qq.demo;

import com.qq.util.ExcelUtil_zqq;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Zqq {
    public static void main(String[] args) {
        String excelFileName = Demo_zqq.class.getResource("/").getPath() + "BaiduTest.xlsx";
        List<Map<String, List<String>>> list = ExcelUtil_zqq.readExcelBYsheetname(excelFileName, "searchTest");
        List<Object[]> testCases = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, List<String>> map = list.get(i);
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                Object[] objects = new Object[entry.getValue().size()];
                for (int j = 0; j < entry.getValue().size(); j++) {
                        objects[0] = entry.getValue().get(0);
                         objects[1] = entry.getValue().get(1);
                         objects[2] = entry.getValue().get(2);

                    }
                testCases.add(objects);
                }

            }

        for (int i = 0; i <testCases.size() ; i++) {
            System.out.println(testCases.get(i));
            for (int j = 0; j <testCases.get(i).length ; j++) {
               System.out.println(testCases.get(i)[j]);
            }

        }
    }

}

