package org.training.big;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by kongyunlong on 2016/10/15.
 */
public class BigDemo {
    public static void main(String[] args) {
        BigDecimal d1 = new BigDecimal("341298732472932434546");
        BigDecimal d3 = new BigDecimal("64653434354545");
        System.out.println(d1.add(d3));
        System.out.println(d1.subtract(d3));
        System.out.println(d1.multiply(d3));
        //没有scale会报错
        System.out.println(d1.divide(d3, d1.scale()));
        //3表示操作使用的数字个数， 结果舍入到此精度， RoundingMode对象， 该对象指定舍入使用的算法
        BigDecimal d2 = new BigDecimal("12.36", new MathContext(3, RoundingMode.HALF_UP));
        System.out.println(d2.toPlainString());

        BigInteger i1 = new BigInteger("12313123123213123123123");
        BigInteger i2 = new BigInteger("12313123123213");
        System.out.println(i1.add(i2));

        BigDecimal d4 = new BigDecimal("5.5", new MathContext(1, RoundingMode.UP));
        System.out.println(d4);
    }
}
