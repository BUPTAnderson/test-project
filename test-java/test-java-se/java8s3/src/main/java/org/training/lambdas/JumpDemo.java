package org.training.lambdas;

import java.util.function.Consumer;

/**
 * Created by kongyunlong on 2016/6/19.
 */
public class JumpDemo {
    public static void main(String[] args) {
        Consumer<int[]> c = ids -> {
          int count = 0;
          for (int id : ids) {
            if (id % 2 == 0) {
                System.out.println(id);
                count++;
                continue;
            }
            if (count == 3) {
                break;
            }
          }
        };

        c.accept(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10});

        for (int i = 0; i < 3; i++) {
            Consumer<Integer> c1 = id -> {
                System.out.println(id);
                if (id == 1) {
                    //不允许在Lambda表达式里面直接使用break或continue来停止外围循环，所以下面的break会报错
//                    break;
                }
            };
            c1.accept(1);
        }
    }
}
