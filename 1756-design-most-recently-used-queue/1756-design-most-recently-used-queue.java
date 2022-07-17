class MRUQueue {

    LinkedList<Integer> q = new LinkedList<>();
        public MRUQueue(int n) {
            for (int i = 1; i <= n; i++) {
                q.addLast(i);
            }
        }

        public int fetch(int k) {
            k -= 1;
            int last = q.get(k);
            q.remove(k);
            q.addLast(last);
            return last;
        }
}

/**
 * Your MRUQueue object will be instantiated and called as such:
 * MRUQueue obj = new MRUQueue(n);
 * int param_1 = obj.fetch(k);
 */