package org.qitu.parser.core.util;

import org.junit.jupiter.api.Test;
import org.qitu.parser.core.exceptions.hex.HexFormatException;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * hex 工具测试
 *
 * @author zoudingyun
 * @since 2024/6/26 17:18
 */
public class HexUtilsTests {

    @Test
    public void testEncode() {

        // check hex
        assertTrue(HexUtils.isHexNumber("0101"));
        assertFalse(HexUtils.isHexNumber("0101 "));
        assertTrue(HexUtils.isHexNumber(HexUtils.formatHexStr("0\nA0 a ")));
        assertThrows(HexFormatException.class, () -> HexUtils.formatHexStr(" "));
        assertThrows(HexFormatException.class, () -> HexUtils.formatHexStr("\t\f"));
        assertThrows(HexFormatException.class, () -> HexUtils.formatHexStr(""));
        assertThrows(HexFormatException.class, () -> HexUtils.formatHexStr("1a3"));
        assertThrows(HexFormatException.class, () -> HexUtils.formatHexStr(null));

        // bytes to hex
        byte[] bytes = new byte[] { 0x01, 0x02, 0x03, -128, 127, -100 };
        assertEquals(HexUtils.encodeHexStr(bytes),"010203807f9c");
        assertEquals(HexUtils.encodeHexStr(bytes,false),"010203807F9C");

        // str to hex
        String str = "哈,d\na %<\\(";
        assertEquals(HexUtils.encodeHexStr(str),"e593882c640a6120253c5c28");
        assertEquals(HexUtils.encodeHexStr(str, StandardCharsets.UTF_8),"e593882c640a6120253c5c28");

        // bytes to chats
        assertEquals(HexUtils.encodeHex(bytes).length,12);
        String hexStr = "010203807f9c";
        char[] chars = HexUtils.encodeHex(bytes);
        for (int i =0;i<chars.length;i++) {
            assertEquals(chars[i],hexStr.charAt(i));
        }

        // str to chars
        assertEquals(HexUtils.encodeHex(str,StandardCharsets.UTF_8).length,24);
        hexStr = "e593882c640a6120253c5c28";
        chars = HexUtils.encodeHex(str,StandardCharsets.UTF_8);
        for (int i =0;i<chars.length;i++) {
            assertEquals(chars[i],hexStr.charAt(i));
        }

        // hex to String
        assertEquals(HexUtils.decodeHexStr("e593882c640a6120253c5c28"),str);
        assertEquals(HexUtils.decodeHexStr("e593882c640a6120253c5c28",StandardCharsets.UTF_8),str);

        // chatHex to String
        assertEquals(HexUtils.decodeHexStr(HexUtils.encodeHex(str,StandardCharsets.UTF_8),StandardCharsets.UTF_8),str);

        // hex to bytes
        assertArrayEquals(HexUtils.decodeHex("010203807F9C"),bytes);
        assertArrayEquals(HexUtils.decodeHex("010203807F9C".toCharArray()),bytes);
        assertArrayEquals(HexUtils.decodeHex((CharSequence)"010203807F9C"),bytes);
    }


}
