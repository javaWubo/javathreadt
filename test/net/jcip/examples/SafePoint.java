package net.jcip.examples;

import net.jcip.annotations.*;

/**
 * SafePoint
 *
 * @author Brian Goetz and Tim Peierls
 * add by wubo
 * 如果在 publicVehicleTracker 中对 返回的位置做了判断则会发生线程安全问题
 */
@ThreadSafe
public class SafePoint {
    @GuardedBy("this") private int x, y;

    private SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    public SafePoint(SafePoint p) {
        this(p.get());
    }

    public SafePoint(int x, int y) {
        this.set(x, y);
    }

    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
