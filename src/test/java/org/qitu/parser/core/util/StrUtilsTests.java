package org.qitu.parser.core.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * hex 工具测试
 *
 * @author zoudingyun
 * @since 2024/6/26 17:18
 */
public class StrUtilsTests {

    @Test
    public void testStrUtils() {

        // check hex
        assertTrue(StrUtils.isBlank(""));
        assertTrue(StrUtils.isBlank(" "));
        assertTrue(StrUtils.isBlank("\t\n\r"));
        assertFalse(StrUtils.isBlank("abc"));
        assertFalse(StrUtils.isBlank("a "));

        assertEquals(StrUtils.trim("abc"),"abc");
        assertEquals(StrUtils.trim("ab c"),"ab c");
        assertEquals(StrUtils.trim(" abc"),"abc");
        assertEquals(StrUtils.trim("abc "),"abc");
        assertEquals(StrUtils.trim(" abc "),"abc");
        assertEquals(StrUtils.trim(" abc"),"abc");
        assertEquals(StrUtils.trim("abc "),"abc");
        assertEquals(StrUtils.trim(" abc "),"abc");
        assertEquals(StrUtils.trim("\t\nabc\r"),"abc");

    }


}
