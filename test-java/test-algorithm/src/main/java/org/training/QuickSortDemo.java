package org.training;

public class QuickSortDemo {
    public static void quickSort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }
        int pivot = a[left]; //定义基准值
        int low = left;
        int high = right;
        while (low < high) {
            while (pivot <= a[high] && low < high)
                high--;
            a[low] = a[high];

            while (pivot >= a[low] && low < high)
                low++;
            a[high] = a[low];
        }

        a[low] = pivot;
        quickSort(a, left, low - 1);
        quickSort(a, low  + 1, right);
    }
    public static void main(String[] args) {
        int[] a = {1, 5, 7, 3, 10, 4, 8, 2, 6, 9};
        quickSort(a, 0, 9);
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }
}
