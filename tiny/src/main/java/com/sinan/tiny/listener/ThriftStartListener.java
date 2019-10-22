package com.sinan.tiny.listener;

import com.sinan.tiny.event.ThriftStartEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;

import java.util.concurrent.atomic.AtomicBoolean;

public class ThriftStartListener implements ApplicationListener<ThriftStartEvent> {

    private static AtomicBoolean startup = new AtomicBoolean(false);

    @Override
    public void onApplicationEvent(ThriftStartEvent event) {
        if (startup.getAndSet(true)) {
            return;
        }
        ApplicationContext context = (ApplicationContext) event.getSource();
        int count = 0;
        while (true) {
            count++;
            System.out.println(count);
            if (count > 100) break;
        }
//        // 条件判断
//        // 判断是否存在ThriftRpcServer类
//        ThriftRpcServer thriftRpcServer = null;
//        try {
//            thriftRpcServer = context.getBean(ThriftRpcServer.class);
//        } catch (Exception exp) {
//            // 忽略异常
//        }
//        // 判断ThriftRpcHttp是否存在
//        ThriftRpcHttp thriftRpcHttp = null;
//        try {
//            thriftRpcHttp = context.getBean(ThriftRpcHttp.class);
//        } catch (Exception exp) {
//            // 忽略异常
//        }
//        ThriftConfigure thriftConfigure = null;
//        try {
//            thriftConfigure = context.getBean(ThriftConfigure.class);
//        } catch (Exception exp) {
//            // 忽略异常
//        }
//        if (thriftConfigure != null) {
//            new ThriftStartupV2().startup(context);
//        } else if (thriftRpcHttp != null || thriftRpcServer != null) {
//            new ThriftStartupV1().startup(context);
//        }
    }

}
