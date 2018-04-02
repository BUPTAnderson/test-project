package org.training;

import java.util.Arrays;

/**
 * Created by anderson on 18-4-3.
 */
public class BubbleSort
{
    public static void BubbleSort(int[] n)
    {
        int temp;
        for (int i = 0; i < n.length - 1; i++) {
            for (int j = i + 1; j < n.length; j++) {
                if (n[i] > n[j]) {         //是对n[i]排序的，这里表示从小到大
                    temp = n[i];
                    n[i] = n[j];
                    n[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int[] a = {51, 46, 20, 18, 65, 97, 82, 30, 77, 50};
        BubbleSort(a);
        System.out.println("排序结果：" + Arrays.toString(a));
    }
}
