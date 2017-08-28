package org.training.lambdas;

import java.util.function.Predicate;

/**
 * Created by anderson on 16-6-18.
 */
//interface Policy {
//    boolean test(int num);
//}
public class SumDemo {
//    public static int add1(int[] nums) {
//        int r = 0;
//        for (int num : nums) {
//            r += num;
//        }
//        return r;
//    }
//
//    public static int add2(int[] nums) {
//        int r = 0;
//        for (int num : nums) {
//            if (num % 2 == 0) {
//                r += num;
//            }
//        }
//        return r;
//    }
//
//    public static int add3(int[] nums) {
//        int r = 0;
//        for (int num : nums) {
//            if (num % 3 == 0) {
//                r += num;
//            }
//        }
//        return r;
//    }

    public static int add(int[] nums, Predicate<Integer> p) {
        int r = 0;
        for (int num : nums) {
            if (p.test(num)) {
                r += num;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int r = add(nums, num -> true);
        System.out.println(r);
//        r = add(nums, new Policy() {
//            @Override
//            public boolean test(int num) {
//                return num % 2 == 0;
//            }
//        });
        r = add(nums, num -> num % 2 == 0);
        System.out.println(r);
//        r = add(nums, new Policy() {
//            @Override
//            public boolean test(int num) {
//                return num % 3 == 0;
//            }
//        });
        r = add(nums, num -> num % 3 == 0);
        System.out.println(r);
//        r = add(nums, new Policy() {
//            @Override
//            public boolean test(int num) {
//                return num % 4 == 0;
//            }
//        });
        r = add(nums, num -> num % 4 == 0);
        System.out.println(r);
    }
}
