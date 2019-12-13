package com.qq.util;

import com.qq.demo.Demo_zqq;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DataProvider_zqq{

    @DataProvider(name = "iterator")
    public Iterator<Object[]> getMethodData1(Method method) {
        String excelFileName = Demo_zqq.class.getResource("/").getPath() + "BaiduTest.xlsx";
        List<Map<String, List<String>>> list = ExcelUtil_zqq.readExcelBYsheetname(excelFileName, method.getName());
        List<Object[]> testCases = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Map<String, List<String>> map = list.get(i);
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                Object[] objects = new Object[entry.getValue().size()];
                for (int j = 0; j < entry.getValue().size(); j++) {
                    objects[j] = entry.getValue().get(j);

                }
                testCases.add(objects);
            }

        }
        return testCases.iterator();
    }

}
