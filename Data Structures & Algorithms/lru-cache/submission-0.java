class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer,Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();

        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        removeNode(node);
        insertToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            insertToHead(node);
        }else{
            if(cache.size()==capacity){
                Node lruNode = tail.prev;
                removeNode(lruNode);
                cache.remove(lruNode.key);
            }
            Node newNode = new Node(key,value);
            cache.put(key,newNode);
            insertToHead(newNode);
        }
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToHead(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}
