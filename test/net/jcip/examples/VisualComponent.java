package net.jcip.examples;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.concurrent.*;

/**
 * VisualComponent(4.3.2 独立的状态变量)
 * <p/>
 * Delegating thread safety to multiple underlying state variables
 *
 * @author Brian Goetz and Tim Peierls
 * add by wubo :
 * 1 CopyOnWriteArrayList 是一个线程安全的列表
 * 2 每个状态之间（keyListLeners 与 mouseListener）不存在羁绊；
 * so VisualComponent 可以将自己的线程安全委托给 keyListLeners 与 mouseListener ;
 */
public class VisualComponent {
    private final List<KeyListener> keyListeners
            = new CopyOnWriteArrayList<KeyListener>();
    private final List<MouseListener> mouseListeners
            = new CopyOnWriteArrayList<MouseListener>();

    public void addKeyListener(KeyListener listener) {
        keyListeners.add(listener);
    }

    public void addMouseListener(MouseListener listener) {
        mouseListeners.add(listener);
    }

    public void removeKeyListener(KeyListener listener) {
        keyListeners.remove(listener);
    }

    public void removeMouseListener(MouseListener listener) {
        mouseListeners.remove(listener);
    }
}
