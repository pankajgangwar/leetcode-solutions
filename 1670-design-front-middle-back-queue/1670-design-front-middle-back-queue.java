class FrontMiddleBackQueue {

        Deque<Integer> first = new ArrayDeque<>();
        Deque<Integer> second = new ArrayDeque<>();
        public FrontMiddleBackQueue() {

        }

        public void a2b(){
            if(first.size() <= second.size()) return;
            second.addFirst(first.removeLast());
        }

        public void b2a(){
            if(second.size() <= first.size() + 1) return;
            first.addLast(second.removeFirst());
        }

        public void pushFront(int val) {
            first.addFirst(val);
            a2b();
        }

        public void pushMiddle(int val) {
            first.addLast(val);
            a2b();
        }

        public void pushBack(int val) {
            second.addLast(val);
            b2a();
        }

        public int popFront() {
            if(first.isEmpty() && second.isEmpty()) return -1;
            if(first.isEmpty()){
                return second.removeFirst();
            }else{
                int remove = first.removeFirst();
                b2a();
                return remove;
            }
        }

        public int popMiddle() {
            if(first.isEmpty() && second.isEmpty()) return -1;
            if(first.size() == second.size()){
                return first.removeLast();
            }else{
                return second.removeFirst();
            }
        }

        public int popBack() {
            if(first.isEmpty() && second.isEmpty()) return -1;
            int remove = second.removeLast();
            a2b();
            return remove;
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