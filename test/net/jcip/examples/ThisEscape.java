package net.jcip.examples;

/**
 * ThisEscape
 * <p/>
 * Implicitly allowing the this reference to escape
 *
 * @author Brian Goetz and Tim Peierls
 */
public class ThisEscape {
    public ThisEscape(EventSource source) {
        source.registerListener(new EventListener() {
            public void onEvent(Event e) {
                doSomething(e);
            }
        });
    }

    void doSomething(Event e) {
    }


    interface EventSource {
        void registerListener(EventListener e);
    }

    interface EventListener {
        void onEvent(Event e);
    }

    interface Event {
    }

    public static void main(String[] args) {
        EventSource eventSource = new EventSource() {
            @Override
            public void registerListener(EventListener e) {

            }

        };
        ThisEscape te = new ThisEscape(eventSource);
        Event event = new Event() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        };
        te.doSomething(event);
    }
}

