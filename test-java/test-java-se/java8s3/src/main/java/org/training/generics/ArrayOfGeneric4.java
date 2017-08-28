package org.training.generics;

import java.lang.reflect.Array;

/**
 * Created by anderson on 16-9-24.
 */
public class ArrayOfGeneric4<T> {
    T[] ts;

    public ArrayOfGeneric4(Class<T> type, int size) {
        /* to solution array of generic key code! */
        ts = (T[]) Array.newInstance(type, size);
    }

    public T get(int index) {
        return ts[index];
    }

    public T[] rep() {
        return ts;
    }

    public void set(int index, T t) {
        ts[index] = t;
    }

    public static void main(String[] args) {
        ArrayOfGeneric4<Integer> aog2 = new ArrayOfGeneric4<Integer>(Integer.class, 10);
        Object[] objs = aog2.rep();
        for (int i = 0; i < 10; i++) {
            aog2.set(i, i);
            System.out.println(aog2.get(i));
        }
        try {
            Integer[] strs = aog2.rep();
            System.out.println("user Array.newInstance to create generci of array was successful!!!!! ");
            for (Integer i : strs) {
                System.out.println("Integer[]:" + i);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
