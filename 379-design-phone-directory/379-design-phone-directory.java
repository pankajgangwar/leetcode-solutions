class PhoneDirectory {
    
        int max = 0;
        int start = 0;

        TreeSet<Integer> available = new TreeSet<>();
        HashSet<Integer> occupied = new HashSet<>();
        HashMap<Integer, Integer> availableSet = new HashMap<>();

        public PhoneDirectory(int maxNumbers) {
            max = maxNumbers;
        }

        public int get() {
            if(!available.isEmpty()){
                int ss = available.pollFirst();
                occupied.add(ss);
                return ss;
            }
            if(start >= max){
                return -1;
            }
            int n = start;
            occupied.add(n);
            start += 1;
            return n;
        }

        public boolean check(int number) {
            return !occupied.contains(number);
        }

        public void release(int number) {
            if(occupied.contains(number)){
                occupied.remove(number);
                available.add(number);    
            }
        }
    
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */