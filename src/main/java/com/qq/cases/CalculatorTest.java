package com.qq.cases;

import com.qq.util.Calculator;
import org.testng.annotations.Test;

/**
 * @description:
 * @author: lu
 * @date 2019/12/12 9:02
 */
public class CalculatorTest {
    @Test
    public void sumTest() {
        Calculator.sum(1, 2, 3, 4, 5);
    }

    @Test
    public void divTest() {
        Calculator.div(10.0, 2);
    }
}
