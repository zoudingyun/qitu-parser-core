package org.qitu.parser.core.lang;

/**
 * 过滤器接口
 *
 * @author zoudingyun
 * @since 0.0.1
 * 2024/6/26 15:32
 */
@FunctionalInterface
public interface Filter<T> {

    /**
     * 是否接受对象
     *
     * @param t 检查的对象
     * @return 是否接受对象
     */
    boolean accept(T t);

}
