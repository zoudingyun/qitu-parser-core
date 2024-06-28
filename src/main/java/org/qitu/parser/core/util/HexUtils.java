package org.qitu.parser.core.util;

import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.StrUtil;
import org.qitu.parser.core.exceptions.ParserException;
import org.qitu.parser.core.exceptions.hex.HexFormatException;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 十六进制 工具类
 * <p>
 * 部分方法来自hutool
 * @author zoudingyun
 * @since 2024/6/26 17:09
 */
public class HexUtils {

    /**
     * 判断给定字符串是否为16进制数<br>
     * 如果是，需要使用对应数字类型对象的{@code decode}方法解码<br>
     * 例如：{@code Integer.decode}方法解码int类型的16进制数字
     *
     * @param value 值
     * @return 是否为16进制
     */
    public static boolean isHexNumber(String value) {
        return HexUtil.isHexNumber(value);
    }

    /**
     * 判断给定字符串是否为16进制数<br>
     * 如果是，需要使用对应数字类型对象的{@code decode}方法解码<br>
     * 例如：{@code Integer.decode}方法解码int类型的16进制数字
     *
     * @param value 值
     * @return 是否为16进制
     */
    public static String formatHexStr(String value) {
        if (value == null || value.isEmpty()) {
            throw new HexFormatException("The hex string cannot be empty");
        }
        // 替换空白字符
        value = StrUtil.cleanBlank(value);
        if (isHexNumber(value)) {
            if (value.length()%2 == 0) {
                return value;
            }else {
                throw new HexFormatException(String.format("\"%s\". The effective character length of this string is odd , but the length of the hex string must be even",value));
            }
        }else {
            throw new HexFormatException(String.format("\"%s\" is not a standard hex string",value));
        }
    }



    /**
     * 将字节数组转换为十六进制字符数组
     *
     * @param data byte[]
     * @return 十六进制char[]
     */
    public static char[] encodeHex(byte[] data) {
        return encodeHex(data, true);
    }

    /**
     * 将字节数组转换为十六进制字符数组
     *
     * @param str     字符串
     * @param charset 编码
     * @return 十六进制char[]
     */
    public static char[] encodeHex(String str, Charset charset) {
        return HexUtil.encodeHex(str,charset);
    }

    /**
     * 将字节数组转换为十六进制字符数组
     *
     * @param data        byte[]
     * @param toLowerCase {@code true} 传换成小写格式 ， {@code false} 传换成大写格式
     * @return 十六进制char[]
     */
    public static char[] encodeHex(byte[] data, boolean toLowerCase) {
        return HexUtil.encodeHex(data,toLowerCase);
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param data byte[]
     * @return 十六进制String
     */
    public static String encodeHexStr(byte[] data) {
        return HexUtil.encodeHexStr(data);
    }

    /**
     * 将字符串转换为十六进制字符串，结果为小写
     *
     * @param data    需要被编码的字符串
     * @param charset 编码
     * @return 十六进制String
     */
    public static String encodeHexStr(String data, Charset charset) {
        return HexUtil.encodeHexStr(data, charset);
    }

    /**
     * 将字符串转换为十六进制字符串，结果为小写，默认编码是UTF-8
     *
     * @param data 被编码的字符串
     * @return 十六进制String
     */
    public static String encodeHexStr(String data) {
        return HexUtil.encodeHexStr(data);
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param data        byte[]
     * @param toLowerCase {@code true} 传换成小写格式 ， {@code false} 传换成大写格式
     * @return 十六进制String
     */
    public static String encodeHexStr(byte[] data, boolean toLowerCase) {
        return HexUtil.encodeHexStr(data, toLowerCase);
    }



    /**
     * 将十六进制字符数组转换为字符串，默认编码UTF-8
     *
     * @param hexStr 十六进制String
     * @return 字符串
     */
    public static String decodeHexStr(String hexStr) {
        return HexUtil.decodeHexStr(hexStr, StandardCharsets.UTF_8);
    }

    /**
     * 将十六进制字符数组转换为字符串
     *
     * @param hexStr  十六进制String
     * @param charset 编码
     * @return 字符串
     */
    public static String decodeHexStr(String hexStr, Charset charset) {
        return HexUtil.decodeHexStr(hexStr, charset);
    }

    /**
     * 将十六进制字符数组转换为字符串
     *
     * @param hexData 十六进制char[]
     * @param charset 编码
     * @return 字符串
     */
    public static String decodeHexStr(char[] hexData, Charset charset) {
        return HexUtil.decodeHexStr(hexData, charset);
    }

    /**
     * 将十六进制字符串解码为byte[]
     *
     * @param hexStr 十六进制String
     * @return byte[]
     */
    public static byte[] decodeHex(String hexStr) {
        return HexUtil.decodeHex(hexStr);
    }

    /**
     * 将十六进制字符数组转换为字节数组
     *
     * @param hexData 十六进制char[]
     * @return byte[]
     * @throws RuntimeException 如果源十六进制字符数组是一个奇怪的长度，将抛出运行时异常
     */
    public static byte[] decodeHex(char[] hexData) {
        return HexUtil.decodeHex(hexData);
    }

    /**
     * 将十六进制字符数组转换为字节数组
     *
     * @param hexData 十六进制字符串
     * @return byte[]
     * @throws ParserException 如果源十六进制字符数组是一个奇怪的长度，将抛出运行时异常
     * @since 5.6.6
     */
    public static byte[] decodeHex(CharSequence hexData) {
        return HexUtil.decodeHex(hexData);
    }


}
