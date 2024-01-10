class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        
        for(char ch : tasks){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            pq.offer(entry.getValue());
        }
        
        HashMap<Integer, Integer> time = new HashMap<>();
        int currTime = 0;
        while(!pq.isEmpty() || !time.isEmpty()){
            
            int prevTime = currTime - n - 1;
            if(time.containsKey(prevTime)){
                int prevRem = time.get(prevTime);
                time.remove(prevTime);
                pq.offer(prevRem);
            }
            
            if(!pq.isEmpty()){
                int rem = pq.poll() - 1;
                if(rem != 0){
                    time.put(currTime, rem);
                }
            }
            currTime += 1;
        }
        return currTime;
        
    }
}