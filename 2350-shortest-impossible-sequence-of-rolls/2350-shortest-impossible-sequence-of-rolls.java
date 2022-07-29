class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int seq = 0;
        HashSet<Integer> sets = new HashSet<>();
        for(int r : rolls){
            sets.add(r);
            if(sets.size() == k){
                sets.clear();
                seq++;
            }
        }
        return seq + 1;
    }
}