package com.wb.test.test.threadmodel;

import net.jcip.examples.NumberRangeChange;

/**
 * Created by wubo5 on 2017/12/4.
 */
public class NumberRangeT2 extends Thread {
    private NumberRangeChange nrc = null;

    public NumberRangeT2(NumberRangeChange nrc) {
        this.nrc = nrc;
    }

    @Override
    public void run(){
        nrc.setUpper(4);
    }
}
