package com.easydemo.gateway.util;

/**
 * @author <a href="mailto:mitsui#shulie.io">mitsui</a>
 * @version 1.0
 * @date 2021-06-25
 */
public class ToolsUtil {

    public static boolean checkMobile(String mobile) {
        return mobile != null && mobile.startsWith("1") && mobile.length() == 11;
    }
}