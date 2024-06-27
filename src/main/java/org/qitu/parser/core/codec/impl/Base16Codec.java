package org.qitu.parser.core.codec.impl;

import org.qitu.parser.core.codec.Decoder;
import org.qitu.parser.core.codec.Encoder;
import org.qitu.parser.core.exceptions.ParserException;
import org.qitu.parser.core.text.CharSequenceUtils;

/**
 * 16进制编解码器
 * <p>
 * 部分工具类改编或节选自hutool
 * @author zoudingyun
 * @since 0.0.1
 * 2024/6/26 14:55
 */
public class Base16Codec implements Encoder<byte[], char[]>, Decoder<CharSequence, byte[]> {

    /**
     * 分别默认定义一个大写和小写16进制字母的编解码器
     * */
    public static final Base16Codec CODEC_LOWER = new Base16Codec(true);
    public static final Base16Codec CODEC_UPPER = new Base16Codec(false);

    private final char[] alphabets;

    /**
     * 构造
     *
     * @param lowerCase 是否小写
     */
    public Base16Codec(boolean lowerCase) {
        this.alphabets = (lowerCase ? "0123456789abcdef" : "0123456789ABCDEF").toCharArray();
    }


    /**
     * 编码
     *
     * @param data 需要编码的数据
     * @return 编码后的数据
     */
    @Override
    public char[] encode(byte[] data) {
        final int len = data.length;
        // 长度翻倍（左移一位会使它的值翻倍），因为2个16进制字母代表一个byte
        final char[] out = new char[len << 1];
        for (int i = 0, j = 0; i < len; i++) {
            // 高位
            out[j++] = alphabets[(0xF0 & data[i]) >>> 4];
            // 低位
            out[j++] = alphabets[0x0F & data[i]];
        }
        return out;
    }

    /**
     * 解码
     *
     * @param data 需要解码的数据
     * @return 解码后的数据
     */
    @Override
    public byte[] decode(CharSequence data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        // 清理空格等空字符
        data = CharSequenceUtils.cleanBlank(data);
        int len = data.length();

        if ((len & 0x01) != 0) {
            // 如果提供的数据是奇数长度，则前面补0凑偶数
            data = "0" + data;
            len = data.length();
        }

        final byte[] out = new byte[len >> 1];

        // two characters form the hex value.
        for (int i = 0, j = 0; j < len; i++) {
            int f = toDigit(data.charAt(j), j) << 4;
            j++;
            f = f | toDigit(data.charAt(j), j);
            j++;
            out[i] = (byte) (f & 0xFF);
        }

        return out;
    }



    /**
     * 将十六进制字符转换成一个整数
     *
     * @param ch    十六进制char
     * @param index 十六进制字符在字符数组中的位置
     * @return 一个整数
     * @throws ParserException 当ch不是一个合法的十六进制字符时，抛出运行时异常
     */
    private static int toDigit(char ch, int index) {
        int digit = Character.digit(ch, 16);
        if (digit < 0) {
            throw new ParserException("Illegal hexadecimal character {} at index {}", ch, index);
        }
        return digit;
    }

}
