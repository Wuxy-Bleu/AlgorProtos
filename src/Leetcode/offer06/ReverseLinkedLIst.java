package Leetcode.offer06;

/*输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。*/

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedLIst {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        //遍历单链表，并且用数组反向输出
        public int[] reversePrint(ListNode head) {
            List<Integer> nums = new ArrayList<>();
            for (ListNode node = head; node != null; node = node.next)
                nums.add(node.val);
            int[] res = new int[nums.size()];
            for (int i = 0; i < res.length; i++)
                res[i] = nums.get(res.length - 1 - i);
            return res;
        }

        public class ListNode {
            int val;
            ListNode next;

            ListNode(int x) {
                val = x;
            }
        }
    }
}
