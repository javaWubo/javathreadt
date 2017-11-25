package com.wb.test.thread;

import net.jcip.examples.CachedFactorizer;

/**
 * Created by 吴波 ;
 * Created on 2017/11/25.
 */
public class CacheFactorizerThread1 extends Thread{
    private CachedFactorizer  cachedFactorizer= null;

    public CacheFactorizerThread1(CachedFactorizer cachedFactorizer) {
        this.cachedFactorizer = cachedFactorizer;
    }

    @Override
    public void run(){
        System.out.println("run------------");
        cachedFactorizer.service(null,null);
    }
}
