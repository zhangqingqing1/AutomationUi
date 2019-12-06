package com.qq.util;

import org.openqa.selenium.support.ui.Wait;
import java.util.function.Function;

public  class MyWait<T> implements Wait {

    private T str;

    public MyWait(T str) {
        this.str = str;
    }

    @Override
    public  Object until(Function function) {
        return  function.apply(str);
    }

    public void setStr(T str) {
        this.str = str;
    }
}
