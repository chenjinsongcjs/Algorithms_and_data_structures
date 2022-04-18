package com.cjs.data_structires.sort;

import java.util.List;

public class InsertSort implements Sort {
    @Override
    public void sort(List<Integer> array) {
        //插入排序，在待排序的数组中选择一个数插入到排好序的数组中
        //稳定性：稳定
        //时间复杂度：O(n^2)
        //假设第一个元素就是有序的
        for (int i = 1; i < array.size(); i++) {
            int j = i;
            for (; j > 0 &&array.get(j-1) > array.get(j) ; j--) {
                    array.set(j,array.get(j-1));
            }
            array.set(j,array.get(i));
        }
    }

    public static void main(String[] args) {
        InsertSort sort = new InsertSort();
        sort.test_sort();
    }
}
