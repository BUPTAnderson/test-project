package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 322
 */
public class CoinChange {
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 方法1： 暴力破解， 递归
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int min = Integer.MAX_VALUE;
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        for (int i = 0; i < coins.length; i++) {
            int current = coinChange(coins, amount - coins[i]);
            if (current == -1) {
                continue;
            }
            if (current + 1 < min) {
                min = current + 1;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    /**
     * 去冗余， 用map来存放已经计算过的 <amount, min>
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange2(int[] coins, int amount) {
        if (map.containsKey(amount)) {
            return map.get(amount);
        }
        int min = Integer.MAX_VALUE;
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        for (int i = 0; i < coins.length; i++) {
            int current = coinChange(coins, amount - coins[i]);
            if (current == -1) {
                continue;
            }
            if (current + 1 < min) {
                min = current + 1;
            }
        }
        if (min == Integer.MAX_VALUE) {
            map.put(amount, -1);
            return -1;
        }
        map.put(amount, min);
        return min;
    }

    /**
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange3(int[] coins, int amount) {

        int min = Integer.MAX_VALUE;
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }
        for (int i = 0; i < coins.length; i++) {
            int current = coinChange(coins, amount - coins[i]);
            if (current == -1) {
                continue;
            }
            if (current + 1 < min) {
                min = current + 1;
            }
        }
        if (min == Integer.MAX_VALUE) {
            map.put(amount, -1);
            return -1;
        }
        map.put(amount, min);
        return min;
    }

    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
        int[] coins = {2};
        int amount = 11;
        amount = 8;
        System.out.println(new CoinChange().coinChange2(coins, amount));
    }
}
