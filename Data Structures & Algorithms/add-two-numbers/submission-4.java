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

        Stack stack1 = new Stack();
        Stack stack2 = new Stack();
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        
        while(curr1 != null || curr2 != null){
            if(curr1 != null){
                stack1.add(curr1.val);
                curr1 = curr1.next;
            }

            if(curr2 != null){
                stack2.add(curr2.val);
                curr2 = curr2.next;
            }
        }

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(!stack1.isEmpty())
                num1.append(stack1.pop());
            if(!stack2.isEmpty())
                num2.append(stack2.pop());
        }

        String sum = sumOfSequences(num1.toString(), num2.toString());

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        
        for (int i = sum.length() - 1; i >= 0 ; i--) {
            curr.next = new ListNode(sum.charAt(i) - '0');
            curr = curr.next;
        }


        return dummy.next;
        

        
    }

     public static String sumOfSequences(String num1, String num2) {
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
