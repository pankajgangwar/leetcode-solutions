class Solution {
    public int[] earliestAndLatest(int n, int first, int second) {
        //helper((1<<n)-1, 1,0, 27, first -1 , second - 1);
        helperMemo((1 << n) - 1, 1, 0, 27, first - 1, second - 1, first - 1, second - first - 1, n - second);
        return new int[]{min_r , max_r};
    }

    int min_r = Integer.MAX_VALUE;
    int max_r = Integer.MIN_VALUE;
    boolean [][][]visited = new boolean[27][27][27];
    public void helperMemo(int mask, int round, int i,
                       int j, int first, int second, int l, int m, int r){
        if(i >= j){
            helperMemo(mask, round + 1, 0, 27, first, second, l, m, r);
        }else if((mask & (1 << i)) == 0){
            helperMemo(mask, round , i+1, j, first, second, l, m, r);
        }else if((mask & (1 << j)) == 0){
            helperMemo(mask, round , i, j-1, first, second, l, m, r);
        }else if(i == first && j == second){
            min_r = Math.min(min_r, round);
            max_r = Math.max(max_r, round);
        }else{
            if(i != first && i != second){
                helperMemo(mask ^ (1<<i), round, i+1,
                        j-1, first, second,
                        l - (i < first ? 1 : 0),
                        m - ((i > first && i < second) ? 1 : 0),
                        r - (i > second ? 1 : 0));
            }
            if(j != first && j != second){
                helperMemo(mask ^ (1<<j), round, i+1,
                        j-1, first, second,
                        l - (j < first ? 1 : 0),
                        m - ((j > first && j < second) ? 1 : 0),
                        r - ((j > second) ? 1 : 0));
            }
        }
    }

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