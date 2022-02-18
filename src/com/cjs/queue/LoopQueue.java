package com.cjs.queue;

/**
 * 循环队列：解决数组队列的出队复杂度过高的问题，不断循环使用数组
 * 属性：front（指向第一个元素）  tail（指向最后一个元素的下一个位置）
 * 判空条件：front == tail
 * 队满条件：tail + 1 == front ,
 * 注意循环取模
 *
 * @param <E>
 */
public class LoopQueue<E> implements Queue<E> {

    E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }


    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enQueue(E e) {
        //扩容考虑
        if ((tail + 1) % data.length == front) {
            resize(data.length * 2);
        }
        //添加元素
        data[tail] = e;
        size++;
        tail = (tail + 1) % data.length;
    }

    //扩容
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        int i = 0;
        while (front % data.length != tail) {
            newData[i++] = data[front];
            front = (front + 1) % data.length;
        }
        front = 0;
        tail = size;
        data = newData;
    }

    @Override
    public E deQueue() {
        if (front == tail)
            throw new IllegalArgumentException("队列为空");
        E retValue = data[front];
        data[front] = null;//help GC
        front = (front + 1) % data.length;
        size--;
        //考虑缩容
        if (size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return retValue;
    }

    @Override
    public E getFront() {
        if (front == tail)
            throw new IllegalArgumentException("队列为空");
        return data[front];
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, data.length));
        res.append("front [");
        for(int i = front ; i != tail ; i = (i + 1) % data.length){
            res.append(data[i]);
            if((i + 1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
