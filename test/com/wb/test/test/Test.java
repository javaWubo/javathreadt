package com.wb.test.test;

import com.wb.test.thread.CacheFactorizerThread1;
import net.jcip.examples.CachedFactorizer;

/**
 * Created by 吴波 ;
 * Created on 2017/11/25.
 */
public class Test {
    public static void main(String[] args) {
        CachedFactorizer cachedFactorizer = new CachedFactorizer();
        CacheFactorizerThread1 cacheFactorizerThread1 = new CacheFactorizerThread1(cachedFactorizer);
        cacheFactorizerThread1.start();
    }

}
