package net.jcip.examples;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * NumberRange
 * <p/>
 * Number range class that does not sufficiently protect its invariants
 *
 * @author Brian Goetz and Tim Peierls
 * add by wubo
 * 如何将下面的类改成 线程安全的：
 * 1 添加同步锁
 * 2 够了
 */

public class NumberRangeChange {
    // INVARIANT: lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);
    ReentrantLock lock = new ReentrantLock();

    public void setLower(int i) {
        // Warning -- unsafe check-then-act
        lock.lock();
        try{
            if (i > upper.get())
                throw new IllegalArgumentException("can't set lower to " + i + " > upper");
            lower.set(i);
        }catch (Exception e){
            System.out.println("error is "+e);
        }finally {
            lock.unlock();
        }

    }

    public void setUpper(int i) {
        // Warning -- unsafe check-then-act
        try{
            lock.lock();
            if (i < lower.get())
                throw new IllegalArgumentException("can't set upper to " + i + " < lower");
            upper.set(i);
        }catch (Exception e){
            System.out.println("error is "+e);
        }finally {
            lock.unlock();
        }

    }

    public boolean isInRange(int i) {
        try{
            lock.lock();
// add by wubo 线程不安全的数据进行了比较数值
            return (i >= lower.get() && i <= upper.get());
        }catch (Exception e){
            System.out.println("error is "+e);
            return false;
        }finally {
            lock.unlock();
        }

    }
}

