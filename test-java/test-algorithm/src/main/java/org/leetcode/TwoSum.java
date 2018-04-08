package org.leetcode;

import java.util.HashMap;

/**
 * leetcode第一题
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 * You may assume that each input would have exactly one solution, and you may not use the same element twice.

 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,

 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    /**
     * 暴力破解，时间复杂度O(n*n)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 利用hash表，时间复杂度o（n）
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int[] result = new TwoSum().twoSum(nums, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(i);
        }

        result = new TwoSum().twoSum1(nums, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(i);
        }
    }
}
