class FrontMiddleBackQueue {

        List<Integer> q = new ArrayList<>();
        public FrontMiddleBackQueue() {

        }

        public void pushFront(int val) {
            q.add(0, val);
        }

        public void pushMiddle(int val) {
            if(q.isEmpty()) {
                q.add(val);
                return;
            }
            int size = q.size();
            int mid = size / 2;
            q.add(mid, val);
        }

        public void pushBack(int val) {
            int size = q.size();
            q.add(size, val);
        }

        public int popFront() {
            if(q.isEmpty()) {
                return -1;
            }
            return q.remove(0);
        }

        public int popMiddle() {
            if(q.isEmpty()) {
                return -1;
            }
            int size = q.size();
            int mid = 0;
            if(size%2==0){
                mid = size / 2 - 1;
            }else{
                mid = size / 2;
            }
            return q.remove(mid);
        }

        public int popBack() {
            if(q.isEmpty()) {
                return -1;
            }
            int size = q.size();
            return q.remove(size - 1);
        }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */