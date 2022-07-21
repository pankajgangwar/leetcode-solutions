class MedianFinder {

    /** initialize your data structure here. */
        PriorityQueue<Integer> firstHalf = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> secondHalf = new PriorityQueue<>();
        public MedianFinder() {

        }

        public void addNum(int num) {
            if(firstHalf.isEmpty() || num < firstHalf.peek()) firstHalf.offer(num);
            else secondHalf.offer(num);

            PriorityQueue<Integer> bigger = firstHalf.size() > secondHalf.size() ? firstHalf : secondHalf;
            PriorityQueue<Integer> smaller = firstHalf.size() < secondHalf.size() ? firstHalf : secondHalf;

            if(bigger.size() - smaller.size() >= 2){
                smaller.offer(bigger.poll());
            }
        }

        public double findMedian() {
            PriorityQueue<Integer> smaller = firstHalf.size() < secondHalf.size() ? firstHalf : secondHalf;
            PriorityQueue<Integer> bigger =  secondHalf.size() > firstHalf.size() ? secondHalf : firstHalf;

            if(smaller.size() == bigger.size()){
                int min = smaller.peek();
                int max = bigger.peek();
                return (double) (min + max) / 2;
            }else {
                return (double) bigger.peek();
            }
        }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */