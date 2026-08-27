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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var current = head;
        int length = 0;
        while(current != null){
            length++;
            current = current.next;
        }
        
        current = head;
        int iterations = length - n;
        while(iterations > 1){
            current = current.next;
            iterations--;
        }
        if(iterations == 0){
            head = current.next;
        }else {
            current.next = current.next.next;
        }
        
        return head;
    }
}
