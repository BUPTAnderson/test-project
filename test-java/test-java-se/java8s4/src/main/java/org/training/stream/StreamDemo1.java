package org.training.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kongyunlong on 2017/8/27.
 */
public class StreamDemo1 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(nums.stream().filter(n -> n % 2 == 0).map(n -> n * 2).reduce(Integer::sum).get());
    }
}
