package org.qitu.parser.core.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * hex 工具测试
 *
 * @author zoudingyun
 * @since 2024/6/26 17:18
 */
public class HexUtilsTests {

    @Test
    public void testEncode() {

        byte[] bytes = new byte[] { 0x01, 0x02, 0x03, -128, 127, -100 };
        assertEquals(HexUtils.encodeHexStr(bytes),"010203807f9c");



    }


}
