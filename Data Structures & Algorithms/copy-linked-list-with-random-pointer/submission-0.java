/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
       public Node copyRandomList(Node head) {
        
        Node current = head;
        Node finder = head;
        ArrayList<Integer> indexes = new ArrayList<>();
        while (current != null){
            int index = 0;
            while(finder != null){
                if (current.random == finder) {
                    indexes.add(index); break;
                }
                else if (current.random == null) {
                    indexes.add(-1);break;
                }
                index++;
                finder = finder.next;
            }
            finder = head;
            current = current.next;
        }
        
        current = head;
        Node dummy = new Node(-101);
        Node tail = dummy;
        
        while (current != null){
            tail.next = new Node(current.val);
            tail = tail.next;
            current = current.next;
        }
        tail = dummy.next;
        current = dummy.next;
        int index = 0;
        while (tail != null){
            int i = indexes.get(index);
            while (i > 0){
                i--;
                current = current.next;
            }
            index++;
            tail.random = i == -1 ? null : current;
            current = dummy.next;
            tail = tail.next;
        }
        
        return dummy.next;
    }
}
