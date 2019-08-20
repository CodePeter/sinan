package com.sinan.log;

import com.sinan.server.CustomClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTest {

    private static final Logger logger = LoggerFactory.getLogger(CustomClient.class);

    public void showLog() {
        logger.info("first {}", "in first");
    }

    public static void main(String[] args) {
//        System.setProperty("localIp", "192.163.0.102");
        System.out.println(System.getProperty("localIp"));
        logger.trace("trace {}", "in trace");
        logger.debug("debug {}", "in debug");
        logger.info("info {}", "in info");
        logger.warn("warn {}", "in warn");
        logger.error("error {}", "in error");
//        Log4jTest test = new Log4jTest();
//        test.showLog();
    }
}
