public class LRUCache {
    class DLinkedList {
        int key;
        int value;
        DLinkedList pre;
        DLinkedList post;
    }
    /*
     * add node just after head
     */
    private void addNode(DLinkedList node) {
        node.pre = head;
        node.post = head.post;
        head.post.pre = node;
        head.post = node;
    }
    private void removeNode(DLinkedList node) {
        DLinkedList preNode = node.pre;
        DLinkedList postNode = node.post;
        preNode.post = postNode;
        postNode.pre = preNode;
    }
    private void moveToHead(DLinkedList node) {
        this.removeNode(node);
        this.addNode(node);
    }
    private DLinkedList popTail() {
        DLinkedList node = tail.pre;
        this.removeNode(node);
        return node;
    }
    
    private HashTable<Integer, DLinkedList> cache = new HashTable<>();
    private int capacity;
    private int count;
    private DLinkedList head, tail;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        head = new DLinkedList();
        head = null;
        tail = new DLinkedList();
        tail = null;
        head.post = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        DLinkedList node = cache.get(key);
        if (node == null) {
            return -1;
        }
        this.moveToHead(node);
        return node.value;
    }
    
    public void set(int key, int value) {
        DLinkedList node = cache.get(key);
        if (node == null) {
            DLinkedList newNode = new DLinkedList();
            newNode.key = key;
            newNode.value = value;
            this.cache.put(key, newNode);
            this.addNode(newNode);
            count++;
            if (count > capacity) {
                DLinkedList tail = this.popTail();
                cache.remove(tail.key);
                count--;
            }
        } else {
            node.value = value;
            this.moveToHead(node);
        }
    }
}