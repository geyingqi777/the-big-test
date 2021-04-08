package gyq.java.algorithm.bit;



public class 删除升序链表中的重复节点 {
    static class ListNode {
        int val;
        ListNode next = null;
    }
    /**
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.next.next == null && head.val == head.next.val) {
            return null;
        }
        // 前后两个指针
        ListNode fast = head.next;
        ListNode slow = head;
        // slow的前一个节点
        ListNode previous = head;
        while (fast != null) {

            if (fast.val == slow.val) {
                // 发现重复元素,向后移动fast
                fast = fast.next;
                continue;
            }

            if (slow.next != fast) {
                // 说明存在重复数据了,fast现在指向重复部分的结尾的next, slow指向了重复部分的开始节点

                if (slow == head) {
                    // 要删除的部分在链表起始的情况,头节点指向fast
                    head = fast;
                } else {
                    // 要删除的部分在链表中间部分的情况
                    slow = fast;
                    fast = fast.next;
                    previous.next = slow;
                }
                continue;
            }
            // 记录前一个节点
            previous = slow;
            // 向后移动
            slow = fast;
            fast = fast.next;
        }
        return head;
    }
}