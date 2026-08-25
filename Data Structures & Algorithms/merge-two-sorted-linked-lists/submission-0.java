/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode newList = new ListNode();

        ListNode newListCurr = newList;

        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                newListCurr.next = new ListNode(curr1.val);
                curr1 = curr1.next;
            } else {
                newListCurr.next = new ListNode(curr2.val);
                curr2 = curr2.next;
            }
            newListCurr = newListCurr.next;
        }

        if (curr1 == null) {
            while (curr2 != null) {
                newListCurr.next = new ListNode(curr2.val);
                newListCurr = newListCurr.next;
                curr2 = curr2.next;
            }
        } else {
            while (curr1 != null) {
                newListCurr.next = new ListNode(curr1.val);
                newListCurr = newListCurr.next;
                curr1 = curr1.next;
            }
        }

        return newList.next;
    }
}