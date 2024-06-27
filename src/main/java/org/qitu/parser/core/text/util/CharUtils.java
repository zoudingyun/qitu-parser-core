package org.qitu.parser.core.text.util;

/**
 * 字符工具类
 * <p>
 * 部分工具类改编或节选自hutool
 * @author zoudingyun
 * @since 0.0.1
 * 2024/6/26 15:42
 */
public class CharUtils {

    /**
     * 是否空白符<br>
     * 空白符包括空格、制表符、全角空格和不间断空格<br>
     *
     * @param c 字符
     * @return 是否空白符
     * @see Character#isWhitespace(int)
     * @see Character#isSpaceChar(int)
     * @since 4.0.10
     */
    public static boolean isBlankChar(char c) {
        return isBlankChar((int) c);
    }


    /**
     * 是否空白符<br>
     * 空白符包括空格、制表符、全角空格和不间断空格<br>
     *
     * @param c 字符
     * @return 是否空白符
     * @see Character#isWhitespace(int)
     * @see Character#isSpaceChar(int)
     * @since 4.0.10
     */
    public static boolean isBlankChar(int c) {
        return Character.isWhitespace(c)
                || Character.isSpaceChar(c)
                || c == '\ufeff'
                || c == '\u202a'
                || c == '\u0000'
                // 'u3164'："Hangul Filler"（韩文填充符）
                || c == 'ㅤ'
                // 'u2800'："Braille Patterns Blank"（盲文图案空白）
                || c == '⠀'
                // "Mongolian Vowel Separator"（蒙古语元音分隔符）
                || c == '\u180e';
    }

}
