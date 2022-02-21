package com.cjs.data_structires.segment_tree;

/**
 * 线段树：主要解决区间问题，一般区间是固定的，求某个区间的最大值，最小值等等，
 * 1.使用数组来存储线段树，大概需要4n的空间，线段树是平衡二叉树，不是完全二叉树。
 * 2.可以设置一个接口，来定义线段树区间的具体含义
 *
 * @param <E>
 */
public class SegmentTree<E> {
    //构建线段树的区间
    private final E[] data;
    //表示线段树的数组
    private final E[] tree;
    //操作函数
    private final Merge<E> merge;

    public SegmentTree(E[] arr, Merge<E> merge) {
        this.merge = merge;
        //构建线段树
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++)
            data[i] = arr[i];
        //需要4倍的空间存储线段树
        tree = (E[]) new Object[4 * data.length];
        buildSegment(0, 0, data.length - 1);

    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    //递归创建线段树，表示在treeIndex创建区间为[l,r]的线段树
    private void buildSegment(int treeIndex, int l, int r) {
        if (l == r) {//递归到底，区间只有一个元素
            tree[treeIndex] = data[l];
            return;
        }
        //区间拆分，递归到底
        int mid = l + (r - l) / 2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        buildSegment(leftIndex, l, mid);
        buildSegment(rightIndex, mid + 1, r);
        //合并，区间真正表示的意思
        tree[treeIndex] = merge.merge(tree[leftIndex], tree[rightIndex]);
    }
    //查询指定区间的结果
    public E query(int queryL,int queryR){
        if(queryL < 0 || queryL >= data.length ||
                queryR < 0 || queryR >= data.length || queryL > queryR)
            throw new IllegalArgumentException("Index is illegal.");
        return query(0,0,data.length-1,queryL,queryR);
    }
    //从treeIndex开始查询指定区间的内容
    private E query(int treeIndex,int l,int r,int queryL,int queryR){
        //分情况，正好找到一个区间表示这个查找区间
        if (l == queryL && r == queryR){
            return tree[treeIndex];
        }
        int mid = l + (r -l )/ 2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        if (queryL > mid)//整个区间在右子树中
            return query(rightIndex,mid+1,r,queryL,queryR);
        else if (queryR <= mid)//这个区间在左子树中
            return query(leftIndex,l,mid,queryL,queryR);
        //区间分布子在右子树中
        E leftResult = query(leftIndex, l, mid, queryL, mid);
        E rightResult = query(rightIndex, mid + 1, r, mid + 1, queryR);
        //合并左右结果返回
        return merge.merge(leftResult,rightResult);
    }
    //线段树的更细
    public void set(int index,E e){
        if (index < 0 || index >= data.length)
            throw new IllegalArgumentException("Index is illegal.");
        data[index] = e;//修改原来的区间
        //修改线段树
        set(0,0,data.length-1,index,e);
    }
    //
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r){
            tree[treeIndex] = e;
            return;
        }
        //没有到底，区间拆分去找
        int mid = l + ( r +l)/2;
        int leftIndex = leftChild(treeIndex);
        int rightIndex = rightChild(treeIndex);
        if (index <= mid)
            set(leftIndex,0,mid,index,e);
        else
            set(rightIndex,mid+1,r,index,e);
        //递归回来把每个区间更新
        tree[treeIndex]  = merge.merge(tree[leftIndex],tree[rightIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public boolean isEmpty() {
        return data.length == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
