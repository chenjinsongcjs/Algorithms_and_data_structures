package com.cjs.data_structires.sort;

import java.util.List;

public class SelectionSort implements Sort{
    @Override
    public void sort(List<Integer> array) {
        //从待排序的数组中选择一个最小的元素放在有序数组的末尾
        //稳定性：关键在于选择最小值的顺序
        //时间复杂度：O(n)
        for (int i = 0; i < array.size(); i++) {
            int min = array.get(i);//每次假设待排序区间的第一个为最小
            int minIndex = i;
            for (int j = i; j < array.size(); j++) {
                if (array.get(j) < min){
                    min = array.get(j);
                    minIndex = j;
                }
            }
            //找到最小，交换
            Sort.swap(array,i,minIndex);
        }
    }

    public static void main(String[] args) {
        SelectionSort sort = new SelectionSort();
        sort.test_sort();
    }
}
