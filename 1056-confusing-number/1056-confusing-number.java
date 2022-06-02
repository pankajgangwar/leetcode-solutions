class Solution {
    
    public boolean confusingNumber(int N) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(8, 8);
        map.put(9, 6);
        map.put(6, 9);
        map.put(1, 1);
        map.put(8, 8);
        map.put(0, 0);
        
        long src = N;
        long res = 0;
        while (N > 0){
            if(!map.containsKey(N % 10)) return false;
            res = res * 10 + map.get(N % 10);
            N /= 10;
        }
        return src != res;
    }
    
}