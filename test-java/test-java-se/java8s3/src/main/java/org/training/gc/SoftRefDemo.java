package org.training.gc;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kongyunlong on 2016/7/9.
 */
class BigObject {
    private long[] nums = new long[4096];
    private long id;

    public BigObject(long id) {
        this.id = id;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println(id + "被回收");
    }
}

public class SoftRefDemo {
    public static void main(String[] args) {
        BigObject b1 = new BigObject(0); //强引用
        SoftReference<BigObject> sr = new SoftReference<BigObject>(b1); //软引用，现在b1即有软引用也存在强引用。
        b1 = null; //赋值为null，就没有强引用了，只剩下软引用。
        List<BigObject> list = new ArrayList<>();
        long i = 1;
        while (true) {
            list.add(new BigObject(i++));
        }
    }
}
