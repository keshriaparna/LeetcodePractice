class Node{
    int key;
    int value;
    int freq;

    Node prev;
    Node next;

    Node(int key,int val){
        this.key = key;
        this.value = val;
        this.freq = 1;
    }
}
class DoublyLinkedList{
    Node head;
    Node tail;
    int size;

    DoublyLinkedList(){
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }
    void add(Node node){
        Node prev = tail.prev;

        prev.next = node;
        node.prev = prev;

        node.next = tail;
        tail.prev = node;

        size++;
    }
    void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;

        size--;
    }
    Node removeFirst(){
        if(size==0) return null;

        Node node = head.next;
        remove(node);
        return node;
    }
}
class LFUCache {

    HashMap<Integer,Node> cache;
    HashMap<Integer,DoublyLinkedList> freqMap;

    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;

        Node node = cache.get(key);
        updateFrequency(node);
        return node.value;
    }
    
    public void put(int key, int val) {
        if(capacity == 0){
            return;
        }
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = val;
            updateFrequency(node);
            return;
        }
        if(cache.size()==capacity){
            DoublyLinkedList list = freqMap.get(minFreq);
            Node remove = list.removeFirst();
            cache.remove(remove.key);
        }
        Node node = new Node(key,val);
        cache.put(key,node);
        freqMap.computeIfAbsent(1,k->new DoublyLinkedList()).add(node);
        minFreq = 1;
    }
    private void updateFrequency(Node node){
        int oldFreq = node.freq;
        DoublyLinkedList oldList = freqMap.get(oldFreq);
        oldList.remove(node);
        if(oldFreq==minFreq && oldList.size==0){
            minFreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq,k->new DoublyLinkedList())
        .add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */