package com.cjs.stack;

/**
 *1.栈是一种线性结构
 * 2.栈操作的是数组的子集只能在栈的一端进行数据的插入和删除
 * 3.栈是一种先进后出的结构 --> First In Last Out
 * 4.在计算机的世界,栈无处不在，如一些Undo撤销操作都需要栈，程序系统调用栈
 */
public interface Stack<E> {
    //获取栈中元素的个数
    int getSize();
    //判断栈是否为空
    boolean isEmpty();
    //压栈
    void push(E e);
    //出栈
    E pop();
    //查看栈顶元素
    E peek();
}
