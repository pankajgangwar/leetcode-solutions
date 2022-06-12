class Solution {
    public int distributeCookies(int[] cookies, int k) {
        helper(cookies, 0, k, new int[k]);
        return res;
    }

    int res = Integer.MAX_VALUE;
    public void helper(int[] cookies, int start, int k, int[] students){
        if(start == cookies.length) {
            int max = 0;
            for(int a : students) max = Math.max(max, a);
            res = Math.min(res, max);
            return;
        }
        for (int i = 0; i < k ; i++) {
            students[i] += cookies[start];
            helper(cookies, start + 1, k, students);
            students[i] -= cookies[start];
        }
    }
}