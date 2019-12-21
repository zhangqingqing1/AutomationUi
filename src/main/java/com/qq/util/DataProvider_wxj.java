package com.qq.util;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

public class DataProvider_wxj {
    @DataProvider(name = "provider")
    public static Object[][] provider(Method method) throws IOException {
        Object[][] obj;
        String testMethodName = method.getName();
        String testClassName = method.getDeclaringClass().getSimpleName();
        String excelPath = DataProvider_wxj.class.getResource("/" + testClassName + ".xlsx").getPath();

        List<HashMap<String, String>> list = ExcelUtil_wxj.readExcel( new File(excelPath),testMethodName);
        int row = list.size();
        obj = new Object[row][3];
        for(int i=0;i<row;i++){
            obj[i][0] = list.get(i).get("keyword");
            obj[i][1] = list.get(i).get("startTime");
            obj[i][2] = list.get(i).get("endTime");
        }
        return obj;
    }
}
