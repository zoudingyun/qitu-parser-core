package org.qitu.parser.core.codec;

/**
 * 编码器接口 (encoder interface)
 *
 * @param <E> 已编码处理过的数据（Encoded）
 * @param <U> 未编码处理过的数据（UnEncoded）
 *
 * @author zoudingyun
 * @since 0.0.1
 * 2024/6/26 14:40
 */
public interface Encoder<U,E> {

    /**
     * 编码
     *
     * @param data 需要编码的数据
     * @return 编码后的数据
     */
    E encode(U data);

}
