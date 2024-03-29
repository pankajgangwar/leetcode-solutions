class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int n = tokens.length;
        int score = 0;
        Arrays.sort(tokens);
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int a : tokens){
            dq.add(a);
        }
        int res = 0;
        while (!dq.isEmpty()){
            if(power >= dq.peekFirst()){
                power -= dq.pollFirst();
                res = Math.max(res, ++score);
            }else if(score > 0){
                power += dq.pollLast();
                --score;
            }else{
                return res;
            }
        }
        return res;
    }
}