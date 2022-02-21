package com.cjs.data_structires.linked_list;

/**
 * 链表是最简单的动态数据结构
 * 链表中的数据是存储在Node节点中
 */
public class LinkedList<E> {
    //存储数据的节点
    private class Node {
        E data;
        Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(E data) {
            this(data, null);
        }

        public Node() {
            this(null);
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    //虚拟头节点
    private Node dummyHead;
    //记录链表中的元素的个数
    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
    }

    public int getSize() {
        return this.size;
    }

    //判断链表是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    //在链表的指定索引添加元素（不常用）
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("索引越界,添加失败");
        Node p = dummyHead;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        p.next = new Node(e, p.next);
        size++;
    }

    //在链表头添加元素
    public void addFirst(E e) {
        add(0, e);
    }

    //在链表尾部添加元素
    public void addLast(E e) {
        add(size, e);
    }

    //获取链表指定索引的元素
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("索引越界，获取元素失败");
        Node p = dummyHead.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.data;
    }

    //获取链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    //获取链表的最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    //修改链表指定索引的元素
    public void set(int index, E e) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("索引越界，修改元素失败");
        Node p = dummyHead.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        p.data = e;
    }

    //判断链表中是否有指定的元素
    public boolean contains(E e) {
        Node p = dummyHead.next;
        while (p != null) {
            if (p.data.equals(e))
                return true;
            else
                p = p.next;
        }
        return false;
    }

    //从链表的指定位置删除元素
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("索引越界，删除元素失败");
        Node p = dummyHead;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        Node delNode = p.next;
        p.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.data;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    //从链表中删除指定元素
    public void removeElement(E e) {
        Node p = dummyHead;
        while (p != null && p.next != null) {
            if (p.next.data.equals(e)) {
                Node delNode = p.next;
                p.next = delNode.next;
                delNode.next = null;
                size--;
                return;
            }
            p = p.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        Node cur = dummyHead.next;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");

        return res.toString();
    }
}














