class OrderedStream {
        String[] arr;
        int ptr;
        public OrderedStream(int n) {
            ptr = 1;
            arr = new String[n + 1];
        }
        public List<String> insert(int id, String value) {
            arr[id] = value;
            List<String> res = new ArrayList<>();
            while (ptr < arr.length && arr[ptr] != null) {
                res.add(arr[ptr++]);
            }
            return res;
        }
    }

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(id,value);
 */