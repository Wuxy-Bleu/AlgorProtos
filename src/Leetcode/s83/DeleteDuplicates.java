package Leetcode.s83;

/*存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。

        返回同样按升序排列的结果链表。*/

public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        //第一想到的就是遍历一遍咯
        ListNode nodeAfter;
        for (ListNode node = head; node != null && node.next != null; node = node.next) {
            for (nodeAfter = node.next; nodeAfter != null; )
                if (nodeAfter.val == node.val) {
                    node.next = nodeAfter.next;
                    nodeAfter = node.next;
                } else
                    break;
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
