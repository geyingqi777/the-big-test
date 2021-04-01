package gyq.java.algorithm.leetcode.p206_reverse_linked_list;

import gyq.java.common_data_struct.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * 206. 反转链表
 *
 * @author geyingqi
 * @see https://leetcode-cn.com/problems/reverse-linked-list/
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        // 头结点的next指向null
        head.next = null;
        while (fast != null) {
            // 名为nextNode的指针, 指向fast.next指向的对象
            ListNode nextNode = fast.next;
            // fast对象的next指针, 指向slow指向的对象
            fast.next = slow;
            // slow指针指向fast指向的对象
            slow = fast;
            // fast指针指向nextNode指向的对象
            fast = nextNode;
        }
        return slow;
    }

    /**
     * 另外一种实现
     *
     * @param head
     * @return
     */
    private static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode nextNode;
        ListNode previous = head;
        
        while (current != null) {
            // 下一个节点
            nextNode = current.next;
            if (current != head) {
                // 下一个节点的指针指向前一个对象
                current.next = previous;
            }
            // 前一个节点
            previous = current;
            // 当前节点
            current = nextNode;
        }
        // 最后一个节点
        return previous;
    }
}