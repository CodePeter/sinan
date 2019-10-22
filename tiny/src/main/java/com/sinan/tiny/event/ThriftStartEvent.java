package com.sinan.tiny.event;

import org.springframework.context.ApplicationEvent;

public class ThriftStartEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    public ThriftStartEvent(Object source) {
        super(source);
    }

}