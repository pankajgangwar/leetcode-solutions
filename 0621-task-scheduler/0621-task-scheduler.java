class Solution {
    
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        
        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ch - 'A']++;
        }
        
        char ch = 'A';
        for(int a : freq){
            if(a > 0){
                pq.offer(a);
            }
            ch++;
        }
        
        int currTime = 0;
        HashMap<Integer, Integer> time = new HashMap<>();
        while(!pq.isEmpty() || !time.isEmpty()){
            int prevTime = currTime - n - 1;
            if(time.containsKey(prevTime)){
                int prevRem = time.get(prevTime);
                time.remove(prevTime);
                pq.offer(prevRem);
            }
            if(!pq.isEmpty()){
                int a = pq.poll() - 1;
                if(a > 0) time.put(currTime, a);
            }
            currTime += 1;
        }
        return currTime;
    }
}