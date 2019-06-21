package org.training.lru.case3;

import org.junit.Test;

/**
 * Created by Anderson on 2019/6/21
 */
public class LRUTest {
    @Test
    public void LruTest() {
        LRU<String,Integer> lru=new LRU<>(3);
//        for(int i=0;i<50;i++) {
//            lru.put("aa"+i, i);
//            lru.print();
//        }
        lru.put("1", 1);
        lru.put("2", 2);
        lru.put("3", 3);
        lru.put("4", 4);
        lru.put("3", 3);
        lru.put("5", 5);
        lru.put("6", 6);
        lru.put("3", 3);
        lru.print();
    }
}
