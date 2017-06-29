package org.training.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kongyunlong on 2016/10/25.
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(10);
        nums.add(4);
        nums.add(6);
        nums.add(2);
        nums.add(9);

        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }

        //自然排序，元素要实现Comparable接口
        Collections.sort(nums);
        nums.forEach(System.out::println);

        System.out.println(Collections.binarySearch(nums, 4));
        System.out.println("------------------------------");
        Collections.shuffle(nums);
        nums.forEach(System.out::println);
        System.out.println("------------------------------");
        Collections.reverse(nums);
        nums.forEach(System.out::println);
        System.out.println("------------------------------");
        //将索引为1,3的元素进行交换
        Collections.swap(nums, 1, 3);
        nums.forEach(System.out::println);

        List<Integer>  nums3 = Collections.checkedList(nums, Integer.class);
        List nums2 = nums3;
        //下面会报错
//        nums2.add("ssss");

        List<String> name = Collections.singletonList("Tom");
        //下面一句报错
        name.add("Jack");
    }
}
