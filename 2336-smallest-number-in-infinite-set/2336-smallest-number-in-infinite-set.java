class SmallestInfiniteSet {

        TreeSet<Integer> infiniteSet = new TreeSet<>();
        int top = 1;
        public SmallestInfiniteSet() {
            
        }

        public int popSmallest() {
            infiniteSet.add(top++);
            return infiniteSet.pollFirst();
        }

        public void addBack(int num) {
            infiniteSet.add(num);
        }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */