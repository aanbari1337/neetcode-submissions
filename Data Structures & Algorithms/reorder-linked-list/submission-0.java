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
    public void reorderList(ListNode head) {
        ListNode curr = head;
        int count = 0;
        Stack<ListNode> stack = new Stack();

        while(curr != null){
            stack.add(curr);
            curr = curr.next;
            count++;
        }
        curr = head;
        int i = 0;
        while (i < count / 2){

            var node = stack.pop();
            var next = curr.next;
            curr.next = node;
            node.next = next;
            curr = next;
            i++;
        }
        curr.next = null;

    }
}
