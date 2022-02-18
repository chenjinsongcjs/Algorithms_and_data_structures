package com.cjs.arrays;

/**
 * 实现自己的一个动态数组，包含数组的增删改查
 * 数组还能动态的扩容和缩容
 */
public class Array<E> {
    //泛型数组，存储真正的数据
    private E[] data;
    //记录当前数组中元素的个数
    private int size;

    //获取当前容器中元素个数
    public int getSize() {
        return this.size;
    }

    //获取当前容器容量
    public int getCapacity() {
        return data.length;
    }

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    //添加操作
    //在指定位置添加
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new ArrayIndexOutOfBoundsException("数组越界");
        //考虑扩容操作
        if (size == getCapacity()) {
            //扩容
            resize(getCapacity() << 1);
        }
        //添加不是覆盖，当前位置之后的所有元素往后移动
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    //向数组的末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    //向数组的头部添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //获取指定索引的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("索引越界");
        return data[index];
    }

    //修改指定位置的元素
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new ArrayIndexOutOfBoundsException("索引越界");
        data[index] = e;
    }

    //判断数组中是否含有某个元素
    public boolean contains(E e) {
        for (E element : data) {
            if (element.equals(e))
                return true;
        }
        return false;
    }

    //在数组中查找每个元素的索引，如果元素不存在返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e))
                return i;
        }
        return -1;
    }

    //从数组中的指定位置删除元素，并且返回删除的元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("索引越界");
        E retValue = data[index];
        //将要删除元素之后的元素向前移动，覆盖删除
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;//帮助GC
        //考虑缩容,当数组中的元素个数为容量的四分之一时缩容为原来的二分之一，避免震荡
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);

        return retValue;
    }
    //删除最后一个元素
    public E removeLast(){
        return remove(size-1);
    }
    //删除第一个元素
    public E removeFirst(){
        return remove(0);
    }
    //从数组中删除指定元素
    public void removeElement(E e){
        int index = find(e);
        if (index != -1)
            remove(index);
    }

    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
    //数组扩容
    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
