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
        if(mMap.containsKey(key)) {
				Node temp = mMap.get(key);
				temp.value = value;
				
				removeNode(temp);
				addToTail(temp);
			}else {
				if(mMap.size() >= cap) {
					mMap.remove(head.key);
					removeNode(head);
				}
				Node child = new Node(key,value);
				addToTail(child);
				mMap.put(key, child);
			}
    }
    
        private void addToTail(Node temp) {
			if(tail != null) {
				tail.next = temp;
			}
			temp.prev = tail;
			temp.next = null;
			tail = temp;
			
			if(head == null) {
				head = tail;
			}
		}

		private void removeNode(Node temp) {
			if(temp.prev != null) {
				temp.prev.next = temp.next;
			}else {
				//Remove from head
				head = temp.next;
			}
			
			if(temp.next != null) {
				temp.next.prev = temp.prev;
			}else {
				//Remove from tail
				tail = temp.prev;
			}
		}
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */