public class LRUCache {

    private class Node {
        int value;
        int key;
        Node next;
        Node prev;


        public Node() {
        }

        public Node(int key, int value) {
            this.value = value;
            this.key = key;
        }
    }

    Map<Integer, Node> cache = new HashMap<>();
    Node left;
    Node right;

    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        left = new Node();
        right = new Node();

        left.next = right;
        right.prev = left;
    }

      private void remove(Node node){
        var prev = node.prev;
        var next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node){

        if(cache.isEmpty()){
            left.next = node;
            node.prev = left;
            right.prev = node;
            node.next = right;
            return;
        }

        var mru = right.prev;
        mru.next = node;
        node.prev = mru;

        node.next = right;
        right.prev = node;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if(node != null){
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {

        if(cache.get(key) != null){
            remove(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        insert(cache.get(key));

        if(cache.size() > capacity){
            var lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }

    }
}
