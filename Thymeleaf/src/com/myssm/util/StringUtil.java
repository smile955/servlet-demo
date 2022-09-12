package com.myssm.util;

/**
 * @class description:
 * @author:杨安益
 * @date:2022/9/11 22:24
 */
public class StringUtil {
    //判断字符串是否为空或者为null
    public static boolean isEmpty(String str) {
        return str == null || "".equals(str);
    }

    public static boolean isNotEmpty(String srt) {
        return !isEmpty(srt);
    }
}
