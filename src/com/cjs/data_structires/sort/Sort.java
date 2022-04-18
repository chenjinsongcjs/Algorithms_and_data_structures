package com.cjs.data_structires.sort;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Sort {
    void sort(List<Integer> array);
    static void swap(List<Integer> array, int i, int j){
        int tmp = array.get(i);
        array.set(i,array.get(j));
        array.set(j,tmp);
    }
    default void test_sort(){
        int size = 10;
        List<Integer> list = Stream.generate(Math::random).limit(size).map(x -> (int)(x * 1_000_000)).collect(Collectors.toList());
        long startTime = System.currentTimeMillis();
        sort(list);
        long endTime = System.currentTimeMillis();
        System.out.println(list);
        System.out.printf("Sort Time %d ms%n",(endTime-startTime));
        boolean flag = false;
        for (int i = 1; i < size; i++) {
            if (list.get(i-1) > list.get(i)){
                flag = true;
                System.out.println("排序失败。");
                break;
            }
        }
        if (!flag)
            System.out.println("排序成功。");
    }
}
