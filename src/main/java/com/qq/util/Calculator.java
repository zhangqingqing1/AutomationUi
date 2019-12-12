package com.qq.util;

import java.util.Arrays;

/**
 * @description: 计算器
 * @author: lu
 * @date 2019/12/12 8:56
 */
public class Calculator {
    /**
     * 统计求和
     * @param args
     * @return
     */
    public static int sum(int... args) {
        return Arrays.stream(args).sum();
    }

    /**
     * 除法运算
     * @param a
     * @param b
     * @return
     */
    public static double div(double a, double b) {
        return a / b;
    }
}
