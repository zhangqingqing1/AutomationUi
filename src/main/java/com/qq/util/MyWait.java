package com.qq.util;

import org.openqa.selenium.support.ui.Wait;
import java.util.function.Function;

public  class MyWait implements Wait {

    private String str;

    public MyWait(String str) {
        this.str = str;
    }

    @Override
    public  Object until(Function function) {
        return  function.apply(str);
    }

    public void setStr(String str) {
        this.str = str;
    }
}
