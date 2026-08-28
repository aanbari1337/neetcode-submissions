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
        Node dummy = new Node(-101);
        Node tail = dummy;
        
        Map<Node, Node> map = new HashMap<>();
        while (current != null){
            tail.next = new Node(current.val);
            tail = tail.next;
            map.put(current, tail);
            current = current.next;
        }
        
          
        for (var entry : map.entrySet()){
            Node copy = entry.getValue();
            Node original = entry.getKey();
            copy.random = map.get(original.random);
        }
        
        return dummy.next;
    }
}
