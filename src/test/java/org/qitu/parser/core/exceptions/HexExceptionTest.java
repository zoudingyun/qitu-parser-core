package org.qitu.parser.core.exceptions;

import org.junit.jupiter.api.Test;
import org.qitu.parser.core.exceptions.hex.HexFormatException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Hex 异常类抛出测试
 *
 * @author zoudingyun
 * @since 2024/6/28 13:54
 */
public class HexExceptionTest {

    @Test
    public void test() {
        assertThrows(HexFormatException.class, this::testMsg);
        assertThrows(HexFormatException.class, this::testCatch);
        assertThrows(HexFormatException.class, this::testFormat);
        assertThrows(HexFormatException.class, this::testCatch2);
        assertThrows(HexFormatException.class, this::testCatch3);
        assertThrows(HexFormatException.class, this::testCatch4);
        assertThrows(HexFormatException.class, this::testCatch5);
        assertThrows(HexFormatException.class, this::testCatch6);
        assertThrows(HexFormatException.class, this::testFormat2);

    }

    // 普通测试
    private void testMsg(){
        throw new HexFormatException("test");
    }

    // 捕捉其它异常测试
    private void testCatch(){
        throw new HexFormatException(new Exception("test"));
    }

    // 异常格式化
    private void testFormat(){
        throw new HexFormatException("test %s to %s","A",2);
    }

    // 捕捉其它异常测试2
    private void testCatch2(){
        throw new HexFormatException("this is a test",new Exception("test"));
    }

    // 捕捉其它异常测试3
    private void testCatch3(){
        throw new HexFormatException("this is a test",new Exception("test"),false,false);
    }

    // 捕捉其它异常测试4
    private void testCatch4(){
        throw new HexFormatException("this is a test",new Exception("test"),false,true);
    }

    // 捕捉其它异常测试5
    private void testCatch5(){
        throw new HexFormatException("this is a test",new Exception("test"),true,false);
    }

    // 捕捉其它异常测试6
    private void testCatch6(){
        throw new HexFormatException("this is a test",new Exception("test"),true,true);
    }

    // 异常格式化2
    private void testFormat2(){
        throw new HexFormatException(new Exception("test"),"test %s to %s","A",2);
    }


}
