package org.qitu.parser.core.util;

import cn.hutool.core.util.StrUtil;

/**
 * 字符串工具类
 *
 * @author zoudingyun
 * @since 2024/7/5 11:31
 */
public class StrUtils {

    private StrUtils() {}

    /**
     * 是否为空白字符串
     * @param string 待判断字符串
     * @return 是否为空字符串（true：空字符串 false：非空）
     * */
    public static boolean isBlank(String string) {
        return StrUtil.isBlankIfStr(string);
    }

    /**
     * 去除首尾空白字符
     * @param string 待处理字符串
     * @return 处理后的字符串
     * */
    public static String trim(String string) {
        return StrUtil.trim(string);
    }

}
