package org.training.lru.case1;

/**
 * Created by Anderson on 2019/6/21
 */
public class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}
