package com.qq.util;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/**
 * @description: 封装数据提供者
 * @author: lu
 * @date 2019/12/11 10:24
 */
public class QQDataProvider {
    @DataProvider(name = "provider")
    public static Object[] provider(Method method) {
        String testClassName = method.getDeclaringClass().getSimpleName();//测试类名，即用例文件名
        String testMethodName = method.getName();//测试方法名，即sheet名
        String excelPath = QQDataProvider.class.getResource("/" + testClassName + ".xlsx").getPath();
        List<Map<String, String>> cases = ExcelUtil.getCases(excelPath, testMethodName);
        Object[] ret = new Object[cases.size()];
        for (int i = 0; i < cases.size(); i++) {
            ret[i] = cases.get(i);
        }
        return ret;
    }
}
