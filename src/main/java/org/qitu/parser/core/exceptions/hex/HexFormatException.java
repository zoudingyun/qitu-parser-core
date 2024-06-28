package org.qitu.parser.core.exceptions.hex;

import org.qitu.parser.core.exceptions.ParserException;

/**
 *  Hex字符串格式错误
 *
 * @author zoudingyun
 * @since 2024/6/28 11:37
 */
public class HexFormatException extends ParserException {

    public HexFormatException(Throwable e) {
        super(e);
    }

    public HexFormatException(String message) {
        super(message);
    }

    public HexFormatException(String messageTemplate, Object... params) {
        super(messageTemplate, params);
    }

    public HexFormatException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public HexFormatException(String message, Throwable throwable, boolean enableSuppression, boolean writableStackTrace) {
        super(message, throwable, enableSuppression, writableStackTrace);
    }

    public HexFormatException(Throwable throwable, String messageTemplate, Object... params) {
        super(throwable, messageTemplate, params);
    }
}
