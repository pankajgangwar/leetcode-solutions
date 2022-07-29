class NumberContainers {

    HashMap<Integer, Integer> indexToNumber = new HashMap<>();
        HashMap<Integer, TreeSet<Integer>> numberToIndex = new HashMap<>();
        public NumberContainers() {

        }

        public void change(int index, int number) {
            if(indexToNumber.containsKey(index)){
                int prev = indexToNumber.get(index);
                numberToIndex.get(prev).remove(index);
                if(numberToIndex.get(prev).isEmpty()){
                    numberToIndex.remove(prev);
                }
            }
            indexToNumber.put(index, number);
            numberToIndex.putIfAbsent(number, new TreeSet<>());
            numberToIndex.get(number).add(index);
        }

        public int find(int number) {
            if(!numberToIndex.containsKey(number)) return -1;
            TreeSet<Integer> pq = numberToIndex.get(number);
            if(pq.isEmpty()) return -1;
            return pq.first();
        }
}

/**
 * Your NumberContainers object will be instantiated and called as such:
 * NumberContainers obj = new NumberContainers();
 * obj.change(index,number);
 * int param_2 = obj.find(number);
 */