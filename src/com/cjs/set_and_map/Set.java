package com.cjs.set_and_map;

/**
 * 集合数据结构：不存放重复的数据
 * @param <E>
 */
public interface Set<E> {
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
