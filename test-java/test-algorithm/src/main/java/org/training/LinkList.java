package org.training;

/**
 * Created by anderson on 18-3-10.
 */

public class LinkList
{
    /**
     * 找到链表的倒数第N个节点
     * <p>
     * 思路: 使用两个指针result, temp, 首先两个指针都执行头节点. 先让temp指针向后移动n-1次, 然后两个指针一起向后移动, 直到temp移动到表尾,
     * 这时候result执行的节点比temp(表为)落后n-1个节点, 即result执行的是倒数第n个节点
     *
     * @param head 头节点
     * @param n 寻找倒数第n个节点
     * @return
     */
    public static ListNode nthNodeFromEnd(ListNode head, int n)
    {
        ListNode result = head;
        ListNode temp = head;
        if (head == null) {
            return null;
        }
        int i = 1;
        while (i < n) {
            temp = temp.getNext();
            if (temp == null) {
                break;
            }
            i++;
        }

        if (temp == null) {
            System.out.println("节点数小于n");
            return null;
        }

        while (temp.getNext() != null) {
            temp = temp.getNext();
            result = result.getNext();
        }

        return result;
    }

    /**
     * 判断链表中是否有环
     * 思路: 快慢指针
     *
     * @param head
     * @return 存在环返回true, 不存在返回false
     */
    public static boolean doesLinkedListContainsLoop(ListNode head)
    {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断链表中是否有环, 如果有找到环的起始位置
     * 思路: 快慢指针判断有没有环, 如果有环, 让slow重新指向head, 然后slow和fast一起移动, 每次只移动一个节点, 它们相遇的位置就是环的起始位置.
     *
     * @param head
     * @return 存在环返回true, 不存在返回false
     */
    public static ListNode findBeginofLoop(ListNode head)
    {
        boolean existLoop = false;
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                existLoop = true;
                break;
            }
        }

        if (existLoop) {
            slow = head;
            while (slow != fast) {
                slow = slow.getNext();
                fast = fast.getNext();
            }
            return slow;
        }
        return null;
    }

    /**
     * 判断链表中是否有环, 如果有返回环的长度
     * 思路: 快慢指针判断有没有环, 如果有环, 让slow重新指向head, 然后slow和fast一起移动, 每次只移动一个节点, 它们相遇的位置就是环的起始位置.
     *
     * @param head
     * @return 存在环返回true, 不存在返回false
     */
    public static int findLoopLength(ListNode head)
    {
        boolean existLoop = false;
        int length = 0;
        if (head == null) {
            return length;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                existLoop = true;
                break;
            }
        }

        if (existLoop) {
            length++;
            fast = fast.getNext();
            while (slow != fast) {
                fast = fast.getNext();
                length++;
            }
        }
        return length;
    }

    /**
     * 判断两个链表是否相交
     * 思路:
     * 方法1:
     * 先遍历第一个链表到他的尾部，然后将尾部的next指针指向第二个链表(尾部指针的next本来指向的是null)。这样两个链表就合成了一个链表，判断原来的两个链表是否相交也就转变成了判断新的链表是否有环的问题了：即判断单链表是否有环？
     * 这样进行转换后就可以从链表头部进行判断了，其实并不用。通过简单的了解我们就很容易知道，如果新链表是有环的，那么原来第二个链表的头部一定在环上。因此我们就可以从第二个链表的头部进行遍历的，从而减少了时间复杂度(减少的时间复杂度是第一个链表的长度)。
     * 方法2:
     * 仔细研究两个链表，如果他们相交的话，那么他们最后的一个节点一定是相同的，否则是不相交的。因此判断两个链表是否相交就很简单了，分别遍历到两个链表的尾部，然后判断他们是否相同，如果相同，则相交；否则不相交。
     *
     * @return
     */
    public static boolean twoLinkListIntersect(ListNode node1, ListNode node2)
    {
        return true;
    }

    /**
     * 判断两个链表是否相交, 如果相交返回交点
     * 思路:
     * 判断出两个链表相交后就是判断他们的交点了。假设第一个链表长度为len1，第二个问len2，然后找出长度较长的，让长度较长的链表指针向后移动|len1 - len2| (len1-len2的绝对值)，然后在开始遍历两个链表，判断节点是否相同即可。
     *
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode findIntersectOfTwoLinkList(ListNode node1, ListNode node2)
    {
        return null;
    }

    /**
     * 单链表反转, 递归法
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head)
    {
        if (head == null || head.getNext() == null) {
            return head;
        }

        ListNode reverseHead = reverseList(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);

        return reverseHead;
    }

    /**
     * 单链表反转, 遍历法
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head)
    {
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode current = head.getNext();
        ListNode temp;
        while (current != null) {
            temp = current.getNext();
            current.setNext(pre);
            pre = current;
            current = temp;
        }
        head.setNext(null);

        return pre;
    }

    /**
     * 反向打印链表
     *
     * @param head
     */
    public static void printListFromEnd(ListNode head)
    {
        if (head == null) {
            return;
        }
        printListFromEnd(head.getNext());
        System.out.println(head.getData());
    }

    /**
     * 合并两个有序列表
     *
     * @param a
     * @param b
     * @return
     */
    public static ListNode mergeList(ListNode a, ListNode b)
    {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode result = null;
        if (a.getData() < b.getData()) {
            result = a;
            result.setNext(mergeList(a.getNext(), b));
        }
        else {
            result = b;
            result.setNext(mergeList(a, b.getNext()));
        }

        return result;
    }

    public static void main(String[] args)
    {
        ListNode head = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n5.setNext(null);
        n4.setNext(n5);
        n3.setNext(n4);
        n2.setNext(n3);
        head.setNext(n2);

//        ListNode result = nthNodeFromEnd(n5, 1);
//        if (result == null) {
//            System.out.println("null");
//        }
//        else {
//            System.out.println(result.getData());
//        }
        printListFromEnd(head);
    }
}
