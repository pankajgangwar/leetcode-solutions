class LRUCache {
    
    Node head;
	Node tail;
	HashMap<Integer, Node> mMap = null;
	int cap = 0;
    
    class Node {
			int key;
			int value;
			Node next;
			Node prev;
			
			public Node(int key, int val) {
				this.value = val;
				this.key = key;
			}
		}
    

    public LRUCache(int capacity) {
        cap = capacity;
        mMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(mMap.get(key) == null) {
				return -1;
		}
		Node temp = mMap.get(key);
		removeNode(temp);
		addToTail(temp);
			
		return temp.value;
    }
    
        public void put(int key, int value) {
            if(mMap.containsKey(key)){
                    Node n = mMap.get(key);
                    n.value = value;
                    removeNode(n);
                    addToTail(n);
                }else{
                    if(mMap.size() >= cap){
                        mMap.remove(head.key);
                        removeNode(head);
                    }
                    Node n = new Node(key, value);
                    mMap.put(key, n);
                    addToTail(n);
                }
        }
        public void removeNode(Node temp){
            if(temp.prev != null){
                temp.prev.next = temp.next;
            }else{
                head = temp.next; //remove from head
            }
            if(temp.next != null){
                temp.next.prev = temp.prev;
            }else{
                tail = temp.prev; //remove from tail
            }
        }

        public void addToTail(Node temp){
            if(tail != null){
                tail.next = temp;
            }
            temp.prev = tail;
            temp.next = null;
            tail = temp;

            if(head == null){
                head = tail;
            }
        }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */