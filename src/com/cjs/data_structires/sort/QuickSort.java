package com.cjs.data_structires.sort;

import java.util.List;
import java.util.stream.Collectors;

//快速排序
public class QuickSort implements Sort{
    @Override
    public void sort(List<Integer> array) {
//        quickSort(array,0,array.size()-1);

    }
    private List<Integer> sort_stream(List<Integer> array){
        //流式计算，快排
        if (array.size() <= 1)
            return array;
        int tmp = array.get(0);
        List<Integer> left = array.stream().filter(x -> x < tmp).collect(Collectors.toList());
        List<Integer> mid = array.stream().filter(x -> x == tmp).collect(Collectors.toList());
        List<Integer> right = array.stream().filter(x -> x > tmp).collect(Collectors.toList());
        sort(left);
        sort(right);
        left.addAll(mid);
        left.addAll(right);
        return left;
    }

    //递归
    private void quickSort(List<Integer> array, int l, int r) {
        if (l >= r)
            return;
        int p = partition_2(array,l,r);
        quickSort(array,l,p-1);
        quickSort(array,p+1,r);
    }
    //双路快排 |--less i--|--equals--|--than  j--|
    private int partition_2(List<Integer> array, int l, int r) {
        //从数组中取一个随机数，定位
        array.set(l,array.get ((int)(Math.random()*(r-l+1))+l));
        int i = l+1;
        int j = r;
        while (true){
            while (i <= r && array.get(i) < array.get(l))
                i++;
            while ( j >= l + 1 && array.get(j) > array.get(l))
                j--;
            if (i > j)
                break;
            Sort.swap(array,i,j);
            i++;
            j--;
        }
        Sort.swap(array,l,j);
        return j ;
    }
    //单路快排
    //使用一个变量作为分界线
    private int partition_1(List<Integer> array, int l, int r) {
        int tmp = array.get(0);
        int j = l;
        for (int i = l+1; i <= r ; i++) {
            if (array.get(i) < tmp){
                Sort.swap(array,j+1,i);
                j++;
            }
        }
        Sort.swap(array,l,j);
        return j;
    }
    //三路快排  l+1 --> lt 小于    lt + 1 -->i - 1 等于    gt-->r大于
    private int[] partition_3(List<Integer> array, int l, int r) {
        int tmp = array.get(0);
        int lt = l;
        int gt = r+ 1;
        int i = l+1;
        while(i < gt){
            if (array.get(i) < tmp){
                Sort.swap(array,lt,i);
                i++;
                lt++;
            }else if (array.get(i) > tmp){
                Sort.swap(array,gt-1,i);
                gt--;
            }else {
                i++;
            }
        }
        Sort.swap(array,l,lt);
        return new int[]{lt-1,gt};
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        quickSort.test_sort();
    }
}
