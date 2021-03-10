package leetcode.s21;
/*将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。*/

public class MergeTwoLIst {

    public static class ListNode {
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

    //单链表合并
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode newList = new ListNode();
        for (ListNode head = newList; l1 != null || l2 != null; head = head.next) {
            if (l1 == null) {
                head.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                head.next = l1;
                l1 = l1.next;
            } else {
                if (l1.val <= l2.val) {
                    head.next = l1;
                    l1 = l1.next;
                } else {
                    head.next = l2;
                    l2 = l2.next;
                }
            }
        }
        return newList.next;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(6, new ListNode(54)));
        ListNode head2 = new ListNode(2, new ListNode(7, new ListNode(17)));
        ListNode listNode = mergeTwoLists(head1, head2);
        System.out.println(listNode);

/*        ListNode head = new ListNode(12, new ListNode(43567));
        ListNode node = head.next;
        ListNode n = new ListNode(123);
        node = n;*/

    }
}
