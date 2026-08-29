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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        appendReverse(l1, num1);
        appendReverse(l2, num2);

        String sum = sumOfSequences(num1.toString(), num2.toString());
        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        
        for (int i = sum.length() - 1; i >= 0 ; i--) {
            curr.next = new ListNode(sum.charAt(i) - '0');
            curr = curr.next;
        }


        return dummy.next;
        

        
    }

    private void appendReverse(ListNode node, StringBuilder result){
        
        if(node == null) return;
        appendReverse(node.next, result);
        result.append(node.val);
    } 

     private String sumOfSequences(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;

            if (i >= 0) {
                sum += num1.charAt(i) - '0'; // Subtract ASCII '0' to get integer value
                i--;
            }
            if (j >= 0) {
                sum += num2.charAt(j) - '0';
                j--;
            }

            result.append(sum % 10);
            carry = sum / 10;
        }

        return result.reverse().toString();
    }
}
