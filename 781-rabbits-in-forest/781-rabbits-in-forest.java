class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int r : answers) {
            if(r == 0) {
                count += 1;
                continue;
            }
            if(!map.containsKey(r)){
                map.put(r, 0);
                count += (r + 1);
            }else{
                map.put(r, map.get(r) + 1);
                if(map.get(r) == r) map.remove(r);
            }
        }
        return count;
    }
}