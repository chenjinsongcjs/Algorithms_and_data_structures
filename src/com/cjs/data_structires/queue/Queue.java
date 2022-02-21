package com.cjs.data_structires.queue;

/**
 *1.队列也是一种线性结构
 * 2.只能在队列中尾部插入元素，从队首取出元素，是一种先进先出的结构-->First In First Out
 * @param <E>
 */
public interface Queue <E>{
    //获取队列中元素的个数
    int getSize();
    //判断队列是否为空
    boolean isEmpty();
    //入队
    void enQueue(E e);
    //出队
    E deQueue();
    //获取队首元素
    E getFront();

}
