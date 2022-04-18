package com.cjs.data_structires.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//冒泡排序
public class BubbleSort implements Sort{
    //两两比较，最终是的最大的元素，移动到最右端
    //是一个稳定的排序算法
    //时间复杂度 O(n^2)
    @Override
    public void sort(List<Integer> array){
        if (array == null  || array.size() == 1)
            return;
        for (int i = 0; i < array.size(); i++) {//需要比较的次数
            for (int j = 1; j < array.size() - i; j++) {//每冒泡一次确定一个元素
                if (array.get(j-1) > array.get(j))
                    Sort.swap(array,j-1,j);//冒泡排序交换次数较多，写内存较多，性能较低
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.test_sort();
    }
}
