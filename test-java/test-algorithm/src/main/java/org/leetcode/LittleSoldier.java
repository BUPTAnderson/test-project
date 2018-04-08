package org.leetcode;

/**
 * N*M的棋盘上， 小兵要从左下角走到右上角， 只能向上或者向右走，问有多少种走法
 */
public class LittleSoldier {
    public static int[][] result = null;

    /**
     * 方法1： 递归 - 暴力搜索
     * @param n
     * @param m
     * @return
     */
    int f(int n, int m) {
        if (n == 0 || m == 0) {
            return 0;
        }
        if (n == 1 || m == 1) {
            return 1;
        }
        return f(n - 1, m) + f(n, m - 1);
    }

    int f2(int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        }
        if (result[n - 1][m - 1] > 0) {
            return result[n - 1][m - 1];
        }
        result[n - 1][m - 1] = f2(n - 1, m) + f(n, m - 1);
        return result[n - 1][m - 1];
    }

    int f3(int n, int m) {
        int[][] sum = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0) {
                    sum[i][j] = 1;
                } else {
                    sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
                }
            }
        }
        return sum[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        System.out.println(new LittleSoldier().f(n, m));

        result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = 0;
            }
        }
        System.out.println(new LittleSoldier().f2(n, m));
        System.out.println(new LittleSoldier().f3(n, m));
    }
}
