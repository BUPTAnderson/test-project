package org.leetcode;

/**
 * • 小偷有一个容量为W的背包，有n件物品，第i个物品价值vi，且重wi • 目标:找到xi使得对于所有的xi={0,1}
 * • sum(wi*xi)<=W,并且sum(xi*vi)最大
 */
public class BackPack {
    // 每个物品的重量
    int[] w = {1, 2, 4, 6, 7};
    // 每个物品的价值
    int[] v = {2, 3, 2, 5, 7};
    // 背包的容量
    int packageCapacity = 15;

    int search(int index, int weight) {
        if (weight > packageCapacity) {
            return 0;
        }
        if (index >= w.length) {
            return 0;
        }
        return Math.max(search(index + 1, weight + w[index]) + v[index], search(index + 1, weight));
    }

    /**
     *
     * @param m 商品个数
     * @param n 背包的最大容量
     * @param w 商品重量数组
     * @param p 商品价值数组
     * @return
     */
    int search(int m, int n, int[] w, int[] p) {
        return Math.max(search(m - 1, n, w, p), search(m - 1, n - w[m - 1]) + p[m]);
    }
    public static void main(String[] args) {
        int m = 3;
        int n = 10;
        int[] w = {3, 4, 5};
        int[] p = {4, 5, 6};
    }
}
