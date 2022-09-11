class Solution {
    
    public int lengthOfLIS(int[] nums, int k) {
        return lengthOfLISSegmentTree(nums, k);
    }
    
    public int lengthOfLISSegmentTree(int[] nums, int k) {
        SegmentTreeRMQ st = new SegmentTreeRMQ(100005);
        int ans = 0;
        for(int v : nums){
            int maxlen = Math.max(0, -st.min(Math.max(v-k, 0), v)) + 1;
            ans = Math.max(ans, maxlen);
            st.update(v, -maxlen);
        }
        return ans;
    }
    
    public int lengthOfLISDP(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];

        for(int i = 0; i < n; i++){
            dp[i] = 1;
        }

        for(int i = 0; i< n; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i] && nums[i] - nums[j] <= k){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
    
    public int lengthOfLISPatienceSort(int[] nums, int k) {
        List<TreeSet<Integer>> piles = new ArrayList<>();
        int ans = 0;
        for (int num : nums) {
            int l = 0, r = piles.size() - 1;
            int idx = -1;
            while (l <= r){
                int m = l + (r - l) / 2;
                Integer smaller = piles.get(m).lower(num);
                if(smaller == null){
                    r = m - 1;
                }else if(smaller + k < num){
                    l = m + 1;
                }else{
                    idx = m;
                    l = m + 1;
                }
            }
            if(idx + 1 == piles.size()){
                piles.add(new TreeSet<>());
            }
            piles.get(idx + 1).add(num);
        }
        return piles.size();
    }
    

public class SegmentTreeRMQ {
    public final int M, H, N;
    public int[] vals;
    public final int I = Integer.MAX_VALUE;

    public SegmentTreeRMQ(int n) {
        N = n;
        M = Integer.highestOneBit(Math.max(N - 1, 1)) << 2;
        H = M >>> 1;
        vals = new int[M];
        Arrays.fill(vals, 0, M, I);
    }

    public SegmentTreeRMQ(int[] a) {
        this(a.length);
        for (int i = 0; i < N; i++) {
            vals[H + i] = a[i];
        }
        //		Arrays.fill(vals, H+N, M, I);
        for (int i = H - 1; i >= 1; i--) propagate(i);
    }

    public void update(int pos, int x) {
        vals[H + pos] = x;
        for (int i = (H + pos) >>> 1; i >= 1; i >>>= 1) propagate(i);
    }

    private void propagate(int i) {
        vals[i] = Math.min(vals[2 * i], vals[2 * i + 1]);
    }

    public int min(int l, int r) {
        int min = I;
        if (l >= r) return min;
        l += H;
        r += H;
        for (; l < r; l >>>= 1, r >>>= 1) {
            if ((l & 1) == 1) min = Math.min(min, vals[l++]);
            if ((r & 1) == 1) min = Math.min(min, vals[--r]);
        }
        return min;
    }

    public int firstle(int l, int v) {
        if (l >= H) return -1;
        int cur = H + l;
        while (true) {
            if (vals[cur] <= v) {
                if (cur >= H) return cur - H;
                cur = 2 * cur;
            } else {
                cur++;
                if ((cur & cur - 1) == 0) return -1;
                if ((cur & 1) == 0) cur >>>= 1;
            }
        }
    }

    public int lastle(int l, int v) {
        if (l < 0) return -1;
        int cur = H + l;
        while (true) {
            if (vals[cur] <= v) {
                if (cur >= H) return cur - H;
                cur = 2 * cur + 1;
            } else {
                if ((cur & cur - 1) == 0) return -1;
                cur--;
                if ((cur & 1) == 1) cur >>>= 1;
            }
        }
    }
}

}