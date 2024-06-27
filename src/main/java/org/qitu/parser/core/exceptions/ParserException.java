package org.qitu.parser.core.exceptions;

import org.qitu.parser.core.exceptions.util.ExceptionUtils;
import org.qitu.parser.core.text.util.StrUtils;

/**
 * 解析器通用异常
 *
 * @author zoudingyun
 * @since 0.0.1
 * 2024/6/26 15:55
 */
public class ParserException extends RuntimeException{

    public ParserException(Throwable e) {
        super(ExceptionUtils.getMessage(e), e);
    }

    public ParserException(String message) {
        super(message);
    }

    public ParserException(String messageTemplate, Object... params) {
        super(StrUtils.format(messageTemplate, params));
    }

    public ParserException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ParserException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }

    public ParserException(Throwable throwable, String messageTemplate, Object... params) {
        super(StrUtils.format(messageTemplate, params), throwable);
    }

}
