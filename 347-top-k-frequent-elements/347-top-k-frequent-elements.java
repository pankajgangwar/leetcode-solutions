class Element{
    int val;
    int frequency;
    public Element(int val){
        this.val = val;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        return usingHeaps(nums, k);
        //return usingBucketSort(nums, k);
        //return usingTreeMap(nums, k);
    }
    
    public int[] usingTreeMap(int[] nums, int k){
    	Map<Integer, Integer> map = new HashMap<>();

    	for (int n : nums){
    		map.put(n , map.getOrDefault(n, 0) + 1);
		}

    	Set<Integer> keys = map.keySet();
		TreeMap<Integer, List<Integer>> treeMap = new TreeMap<>(Collections.reverseOrder());
    	
        for(int ele : keys){
    		int freq = map.get(ele);
            treeMap.putIfAbsent(freq, new ArrayList<>());
            treeMap.get(freq).add(ele);
		}
        
        int[] res = new int[k];
        int idx = 0;
    	Set<Integer> treeKey = treeMap.keySet();
    	Iterator<Integer> it = treeKey.iterator();
    	while (it.hasNext() && idx < k){
			List<Integer> curr = treeMap.get(it.next());
            for(int ele : curr){
                res[idx++] = ele;
            }
		}
    	return res;
	}
    
     public int[] usingBucketSort(int[] nums, int k){
		List<Integer>[] bucket = new List[nums.length + 1];
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}

		for(Map.Entry<Integer, Integer> entry : map.entrySet()){
			List<Integer> list = null;
			if(bucket[entry.getValue()] == null){
				bucket[entry.getValue()] = new ArrayList<>();
			}
			bucket[entry.getValue()].add(entry.getKey());
		}

		List<Integer> result = new ArrayList<>(k);
		for (int i = bucket.length - 1; i >= 0 && result.size() < k ; --i) {
			if(bucket[i] != null){
                Collections.sort(bucket[i]);
				result.addAll(bucket[i]);
			}
		}
        int[] res = new int[k];
        int idx = 0;
        for(int ele : result) {
            res[idx++] = ele;
        }
		return res;
	}
    
    public int[] usingHeaps(int[] nums, int k){
        Map<Integer, Integer> mMap = new HashMap<>();
        PriorityQueue<Element> mMinHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.frequency));
        for(int i = 0; i < nums.length; i++ ){
            int ele = nums[i];
            mMap.put(ele, mMap.getOrDefault(ele, 0) + 1);
        }
        for(Integer entry : mMap.keySet()) {
            Element ele = new Element(entry);
            ele.frequency = mMap.get(entry);
            mMinHeap.offer(ele);
            while(mMinHeap.size() > k) {
                mMinHeap.poll();
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!mMinHeap.isEmpty()) {
            res.add(mMinHeap.poll().val);
        }
        Collections.reverse(res);
        return res.stream().mapToInt(i -> i).toArray();
    }
    
}