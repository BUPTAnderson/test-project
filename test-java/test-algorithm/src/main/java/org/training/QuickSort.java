package org.training;

import java.util.Arrays;

/**
 * Created by anderson on 18-4-3.
 */
public class QuickSort
{
    public static void quickSort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = a[left];
        int low = left;
        int high = right;
        while (low < high) {
            while (pivot <= a[high] && low < high) {
                high--;
            }
            a[low] = a[high];

            while (pivot >= a[low] && low < high) {
                low++;
            }
            a[high] = a[low];
        }

        a[low] = pivot;
        quickSort(a, left, low - 1);
        quickSort(a, low + 1, right);
    }
    public static void main(String[] args)
    {
//        int[] a = {1,2,3,4,5,6,0,7,8,9,10,0};
        int[] a = { 49, 38, 65, 97, 76, 13, 27, 49 };
        quickSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }
}
