package org.qitu.parser.core.exceptions.util;

import org.qitu.parser.core.text.util.StrUtils;

/**
 * 异常工具类
 * <p>
 * 来源：hutool
 * @author zoudingyun
 * @since 2024/6/26 16:02
 */
public class ExceptionUtils {

    /**
     * 获得完整消息，包括异常名，消息格式为：{SimpleClassName}: {ThrowableMessage}
     *
     * @param e 异常
     * @return 完整消息
     */
    public static String getMessage(Throwable e) {
        if (null == e) {
            return StrUtils.NULL;
        }
        return StrUtils.format("{}: {}", e.getClass().getSimpleName(), e.getMessage());
    }

}
