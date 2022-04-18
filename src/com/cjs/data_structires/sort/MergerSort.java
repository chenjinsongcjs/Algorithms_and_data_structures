package com.cjs.data_structires.sort;

import java.util.Arrays;
import java.util.List;

public class MergerSort implements Sort{
    @Override
    public void sort(List<Integer> array) {
        sort(array,0,array.size()-1);
    }
    //使用左闭右开区间
    private void sort(List<Integer> array,int i,int j){
        if (i >= j)
            return;
        //拆分，递归排序
        int mid = i + (j - i) / 2;
        sort(array,i,mid);
        sort(array,mid+1,j);
        //有序就不用merger
        if (array.get(mid) > array.get(mid+1))
            merger(array,i,mid,j);
    }
    private void merger(List<Integer> array, int i, int mid, int j) {
       //创建临时数组进行merger
        int[] tmp = new int[j-i+1];
        for (int k = i; k <= j; k++) {
            tmp[k - i] = array.get(k);
        }
        int l = i;
        int r = mid+1;
        //将临时数组的数据归并到原来的数组中
        for (int k = i; k <= j ; k++) {
            if (l > mid){
                //左边数组扫描完毕
                array.set(k,tmp[r - i ]);
                r++;
            }else if (r > j){//右边数组扫描完
                array.set(k,tmp[l-i]);
                l++;
            }else if (tmp[l-i] > tmp[r - i]){//谁小就记录谁
                array.set(k,tmp[r - i]);
                r++;
            }else {
                array.set(k,tmp[l - i]);
                l++;
            }
        }

    }

    public static void main(String[] args) {
        MergerSort sort = new MergerSort();
        sort.test_sort();
    }
}
