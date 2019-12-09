package com.qq.demo;




import com.qq.util.ExcelDataVO_zqq;
import com.qq.util.ExcelUtil_zqq;

import java.util.*;

public class Zqq {

public static void main(String[] args) {

    // 设定Excel文件所在路径
    String excelFileName = "E://workspace//AutomationUi//src//main//resources//Excel用例模板.xlsx" ;
    System.out.println(excelFileName);
    // 读取Excel文件内容
   List<ExcelDataVO_zqq> readResult = ExcelUtil_zqq.readExcel(excelFileName);
    for (int i = 0; i <readResult.size() ; i++) {
        System.out.println("用例编号: "+readResult.get(i).getCaseName()+"关键字: "+readResult.get(i).getKeyword()+"开始时间:"+readResult.get(i).getStartTime()+"结束时间:"+readResult.get(i).getEndTime());

    }
}
}


