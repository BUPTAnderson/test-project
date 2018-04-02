package org.training;

import java.util.Arrays;

/**
 * Created by anderson on 18-4-3.
 * 归并排序
 * 链接: https://blog.csdn.net/jianyuerensheng/article/details/51262984
 */
public class MergeSort
{
    public static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= high) {
            temp[k++] = a[j++];
        }

        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }
    public static void mergSort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergSort(a, low, mid);
            mergSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }
    public static void main(String[] args)
    {
        int[] a = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        mergSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }
}
