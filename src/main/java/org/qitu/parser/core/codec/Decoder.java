package org.qitu.parser.core.codec;

/**
 * 解码器接口 (decoder interface)
 *
 * @param <E> 已编码处理过的数据（Encoded）
 * @param <U> 未编码处理过的数据（UnEncoded）
 *
 * @author zoudingyun
 * @since 0.0.1
 * 2024/6/26 14:40
 */
public interface Decoder<E,U> {

    /**
     * 解码
     *
     * @param data 需要解码的数据
     * @return 解码后的数据
     */
    U decode(E data);

}
