class Solution {
    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        TreeMap<Long, HashSet<Long>> pq = new TreeMap<>(Collections.reverseOrder());
        int n = freq.length;
        long[] res = new long[n];

        HashMap<Long, Long> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long num = (long)nums[i];
            if(freq[i] < 0){
                if(freqMap.containsKey(num)){
                    long fr = freqMap.get(num);
                    pq.get(fr).remove(num);
                    if(pq.get(fr).isEmpty()){
                        pq.remove(fr);
                    }
                    long newfr = fr + freq[i];
                    if(newfr != 0){
                        pq.putIfAbsent(newfr, new HashSet<>());
                        pq.get(newfr).add(num);
                        freqMap.put(num, newfr);
                    }else{
                        freqMap.remove(num);
                    }
                }else{
                    pq.putIfAbsent((long)freq[i], new HashSet<>());
                    pq.get((long)freq[i]).add(num);
                }
            }else{
                if(freqMap.containsKey(num)){
                    long fr = freqMap.get(num);
                    pq.get(fr).remove(num);
                    if(pq.get(fr).isEmpty()){
                        pq.remove(fr);
                    }
                    long newfr = fr + freq[i];
                    if(newfr != 0){
                        freqMap.put(num, newfr);
                        pq.putIfAbsent(newfr, new HashSet<>());
                        pq.get(newfr).add(num);
                    }else{
                        freqMap.remove(num);
                    }
                }else{
                    pq.putIfAbsent((long)freq[i], new HashSet<>());
                    pq.get((long)freq[i]).add(num);
                    freqMap.put(num, (long)freq[i]);
                }
            }
            res[i] = pq.isEmpty() ? 0L : pq.firstKey();
        }
        return res;
    }
}