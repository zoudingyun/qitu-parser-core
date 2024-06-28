package org.qitu.parser.core.exceptions.util;

import cn.hutool.core.exceptions.ExceptionUtil;

/**
 * 异常工具类
 *
 * @author zoudingyun
 * @since 2024/6/26 16:02
 */
public class ExceptionUtils {

    private ExceptionUtils() {}

    /**
     * 获得完整消息，包括异常名，消息格式为：{SimpleClassName}: {ThrowableMessage}
     *
     * @param e 异常
     * @return 完整消息
     */
    public static String getMessage(Throwable e) {
        return ExceptionUtil.getMessage(e);
    }

}
