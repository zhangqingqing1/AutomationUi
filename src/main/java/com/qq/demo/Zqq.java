package com.qq.demo;

import com.qq.util.ExcelUtil_zqq;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Zqq {
    public static <list> void main(String[] args) {
        String excelFileName = Zqq.class.getResource("/").getPath() + "Demo_zqq.xlsx";
        System.out.println(excelFileName);
        List<Map<String, List<String>>> list = ExcelUtil_zqq.readExcelBYsheetname(excelFileName, "searchTest");
        List<String> list1 = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, List<String>> map = list.get(i);
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                for (int j = 0; j < entry.getValue().size(); j++) {
                    list1.add(entry.getValue().get(j));

                }

            }
        }
        Object[] objects = new Object[list1.size()];
        list1.toArray(objects);
    }

    }






