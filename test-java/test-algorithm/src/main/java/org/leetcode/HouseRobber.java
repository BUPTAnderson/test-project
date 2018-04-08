package org.leetcode;

/**
 * 四个步骤
 • 设计暴力算法，找到冗余
 • 设计并存储状态（一维，二维，三维数组，甚至用Map）
 • 递归式（状态转移方程）
 • 自底向上计算最优解（编程方式）
 类似问题见LittleSoldier
 */
public class HouseRobber {
    public int rob(int[] nums) {
        return solve(nums, nums.length - 1);
    }

    /**
     * 方法1： 递归暴力破解
     * @param nums
     * @return
     */
    public int solve(int[] nums, int index) {
        if (index < 0) {
            return 0;
        }
        return Math.max(nums[index] + solve(nums, index - 2), solve(nums, index - 1));
    }

    /**
     * 方法2： 处理重叠子问题
     * @param nums
     * @param index
     * @return
     */
    public int solve1(int[] nums, int index) {
        if (index < 0) {
            return 0;
        }
        if (result[index] >= 0) {
            return result[index];
        }
        result[index] = Math.max(nums[index] + solve1(nums, index - 2), solve1(nums, index - 1));
        return result[index];
    }

    public static int[] result;

    public int rob1(int[] nums) {
        result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
        }
        return solve(nums, nums.length - 1);
    }

    /**
     * 上面的递归采用的是自定向下计算的方式， 即通过N-1来解决N， 通过N-2来解决N-1 ...
     * 通过递归方式找到状态转移方程，从而推出自底向上的方式（递推）：
     * result[i] = Math.max(nums[i] + result[i - 2], result[i - 1]);
     * @param nums
     * @return
     */
    public int rob2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max(nums[i] + result[i - 2], result[i - 1]);
        }
        return result[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 5, 4};
        System.out.println(new HouseRobber().rob(test));

        // 处理重叠子问题
        System.out.println(new HouseRobber().rob1(test));
        System.out.println(new HouseRobber().rob2(test));
    }
}
