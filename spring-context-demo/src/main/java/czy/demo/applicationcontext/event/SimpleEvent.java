package czy.demo.applicationcontext.event;

import org.springframework.context.ApplicationEvent;

public class SimpleEvent extends ApplicationEvent {


    public SimpleEvent(Object source) {
        super(source);
    }

    @Override
    public Object getSource() {
        return super.getSource();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
