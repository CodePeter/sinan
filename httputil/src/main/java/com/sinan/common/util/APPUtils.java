package com.sinan.common.util;

import org.apache.commons.lang3.StringUtils;

public class APPUtils {
    private static String APP_NAME = "";
    public static String getAppName() {
        if(StringUtils.isNotEmpty(APP_NAME)){
            return APP_NAME;
        }
        // appName first get evn
        String property_appName = System.getProperty("APP_NAME");
        if (property_appName != null && !"".equals(property_appName)) {
            APP_NAME = property_appName;
            return APP_NAME;
        }
        String path = System.getProperty("user.dir");
        if (path.contains("/")) {
            String[] pathArray = path.split("/");
            if (pathArray.length > 1) {
                APP_NAME =  pathArray[pathArray.length - 2];
                return APP_NAME;
            }
        }
        return "";
    }
}
