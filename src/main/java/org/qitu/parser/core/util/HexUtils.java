package org.qitu.parser.core.util;

import org.qitu.parser.core.codec.impl.Base16Codec;
import org.qitu.parser.core.exceptions.ParserException;
import org.qitu.parser.core.text.util.StrUtils;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 十六进制 工具类
 * <p>
 * 来自hutool
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
        if(StrUtils.startWith(value, '-')){
            return false;
        }
        int index = 0;
        if (value.startsWith("0x", index) || value.startsWith("0X", index)) {
            index += 2;
        } else if (value.startsWith("#", index)) {
            index ++;
        }
        try {
            new BigInteger(value.substring(index), 16);
        } catch (final NumberFormatException e) {
            return false;
        }
        return true;
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
        return encodeHex(StrUtils.bytes(str, charset), true);
    }

    /**
     * 将字节数组转换为十六进制字符数组
     *
     * @param data        byte[]
     * @param toLowerCase {@code true} 传换成小写格式 ， {@code false} 传换成大写格式
     * @return 十六进制char[]
     */
    public static char[] encodeHex(byte[] data, boolean toLowerCase) {
        return (toLowerCase ? Base16Codec.CODEC_LOWER : Base16Codec.CODEC_UPPER).encode(data);
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param data byte[]
     * @return 十六进制String
     */
    public static String encodeHexStr(byte[] data) {
        return encodeHexStr(data, true);
    }

    /**
     * 将字符串转换为十六进制字符串，结果为小写
     *
     * @param data    需要被编码的字符串
     * @param charset 编码
     * @return 十六进制String
     */
    public static String encodeHexStr(String data, Charset charset) {
        return encodeHexStr(StrUtils.bytes(data, charset), true);
    }

    /**
     * 将字符串转换为十六进制字符串，结果为小写，默认编码是UTF-8
     *
     * @param data 被编码的字符串
     * @return 十六进制String
     */
    public static String encodeHexStr(String data) {
        return encodeHexStr(data, StandardCharsets.UTF_8);
    }

    /**
     * 将字节数组转换为十六进制字符串
     *
     * @param data        byte[]
     * @param toLowerCase {@code true} 传换成小写格式 ， {@code false} 传换成大写格式
     * @return 十六进制String
     */
    public static String encodeHexStr(byte[] data, boolean toLowerCase) {
        return new String(encodeHex(data, toLowerCase));
    }



    /**
     * 将十六进制字符数组转换为字符串，默认编码UTF-8
     *
     * @param hexStr 十六进制String
     * @return 字符串
     */
    public static String decodeHexStr(String hexStr) {
        return decodeHexStr(hexStr, StandardCharsets.UTF_8);
    }

    /**
     * 将十六进制字符数组转换为字符串
     *
     * @param hexStr  十六进制String
     * @param charset 编码
     * @return 字符串
     */
    public static String decodeHexStr(String hexStr, Charset charset) {
        if (StrUtils.isEmpty(hexStr)) {
            return hexStr;
        }
        return StrUtils.toStr(decodeHex(hexStr), charset);
    }

    /**
     * 将十六进制字符数组转换为字符串
     *
     * @param hexData 十六进制char[]
     * @param charset 编码
     * @return 字符串
     */
    public static String decodeHexStr(char[] hexData, Charset charset) {
        return StrUtils.toStr(decodeHex(hexData), charset);
    }

    /**
     * 将十六进制字符串解码为byte[]
     *
     * @param hexStr 十六进制String
     * @return byte[]
     */
    public static byte[] decodeHex(String hexStr) {
        return decodeHex((CharSequence) hexStr);
    }

    /**
     * 将十六进制字符数组转换为字节数组
     *
     * @param hexData 十六进制char[]
     * @return byte[]
     * @throws RuntimeException 如果源十六进制字符数组是一个奇怪的长度，将抛出运行时异常
     */
    public static byte[] decodeHex(char[] hexData) {
        return decodeHex(String.valueOf(hexData));
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
        return Base16Codec.CODEC_LOWER.decode(hexData);
    }


}
