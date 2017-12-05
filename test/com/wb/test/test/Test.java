package com.wb.test.test;

import com.wb.test.test.threadmodel.NumberRangeT1;
import com.wb.test.test.threadmodel.NumberRangeT2;
import com.wb.test.thread.CacheFactorizerThread1;
import net.jcip.examples.CachedFactorizer;
import net.jcip.examples.NumberRangeChange;

/**
 * Created by 吴波 ;
 * Created on 2017/11/25.
 */
public class Test {
//    public static void main(String[] args) {
//        CachedFactorizer cachedFactorizer = new CachedFactorizer();
//        CacheFactorizerThread1 cacheFactorizerThread1 = new CacheFactorizerThread1(cachedFactorizer);
//        cacheFactorizerThread1.start();
//    }
    /**
     * NumberRange test
     *
     */

    public static void main(String[] args) {
        NumberRangeChange nrc = new NumberRangeChange();
        NumberRangeT1 nrt1 = new NumberRangeT1(nrc);
        NumberRangeT2 nrt2 = new NumberRangeT2(nrc);
        nrt1.start();
        nrt2.start();
        nrc.isInRange(1);
    }

}
