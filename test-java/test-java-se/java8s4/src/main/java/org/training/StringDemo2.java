package org.training;

/**
 * Created by anderson on 16-10-8.
 */
public class StringDemo2 {
    public static void main(String[] args) {
        //所有编译时的常量字符串字面量都会加入到String池中
        final String constStr = "He";
        String varStr = "He";
        String s1 = constStr + "llo";
        String s2 = varStr + "llo";
        String s3 = "He" + "llo";
        //s1和s2都是 变量 + "llo"，但是s1中的变量是final的，在编译时就是确定的值，而s2中的变量不是，在编译时无法确定值。
        // 所以，s1指向常量池中的"Hello"，s2指向堆中的"Hello"
//        System.out.println("Hello" == s1); //true
//        System.out.println("Hello" == s2); //false
        //s3在编译时也是确定的值，所以s3指向常量池中的"Hello"
//        System.out.println("Hello" == s3); //true
    }
}
