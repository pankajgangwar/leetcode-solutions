class Solution {
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        helper((1<<n)-1, 1,0, 27, firstPlayer -1 , secondPlayer - 1);
        return new int[]{min_r , max_r};
    }

    int min_r = Integer.MAX_VALUE;
    int max_r = Integer.MIN_VALUE;
    public void helper(int mask, int round, int i,
                      int j, int first, int second){
        if(i >= j){
            helper(mask, round + 1, 0, 27, first, second);
        }else if((mask & (1 << i)) == 0){
            helper(mask, round , i+1, j, first, second);
        }else if((mask & (1 << j)) == 0){
            helper(mask, round , i, j-1, first, second);
        }else if(i == first && j == second){
            min_r = Math.min(min_r, round);
            max_r = Math.max(max_r, round);
        }else{
            if(i != first && i != second){
                helper(mask ^ (1<<i), round, i+1, j-1, first, second);
            }
            if(j != first && j != second){
                helper(mask ^ (1<<j), round, i+1, j-1, first, second);
            }
        }
    }
}