package com.cjs.algorithms.leetcode.jianzhiOffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在重复元素值的数组numbers，
 * 它原来是一个升序排列的数组，并按上述情形进行了一次旋转。
 * 请返回旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，
 * 该数组的最小值为1。
 *https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class MinArray {
    //二分法,使用中间值和最右边的值比较，判断最小值的区间
    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        while( i < j){
            int mid = i + (j -i )/2;
            if (numbers[mid] > numbers[j] )
                i = mid + 1;
            else if (numbers[mid] < numbers[j])
                j = mid;
            else //遇到重复缩小区间
                j--;
        }
        return numbers[i];
    }
}
