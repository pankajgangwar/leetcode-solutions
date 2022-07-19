class Solution {

    public int sumSubarrayMins(int[] arr) {
         return usingMonotoneStack(arr);
        //return helper(arr);
    }

    public int helper(int[] nums) {
        int n = nums.length;
        long res = 0;
        int j, k;
        Stack<Integer> s = new Stack<>();
        long mod = (long) 1e9 + 7;
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && nums[s.peek()] > (i == n ? Integer.MIN_VALUE : nums[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                long a = ((i - j) * (j - k));
                long b = (a * nums[j]) % mod;
                res = (res + b) % mod;
                res = res % mod;
            }
            s.push(i);
        }
        return (int) res;
    }

    public int usingMonotoneStack(int[] arr) {
        Stack<int[]> stk_p = new Stack<>();
        Stack<int[]> stk_n = new Stack<>();
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < n; i++) {
            left[i] = i + 1;
            right[i] = n - i;
        }

        for (int i = 0; i < n; i++) {
            while (!stk_p.isEmpty() && stk_p.peek()[0] > arr[i]) {
                stk_p.pop();
            }
            left[i] = stk_p.isEmpty() ? (i + 1) : (i - stk_p.peek()[1]);
            stk_p.push(new int[] { arr[i], i });
        }

        for (int i = 0; i < n; i++) {
            while (!stk_n.isEmpty() && stk_n.peek()[0] > arr[i]) {
                int[] top = stk_n.pop();
                right[top[1]] = i - top[1];
            }
            stk_n.push(new int[] { arr[i], i });
        }

        long ans = 0;
        long mod = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            long a = (arr[i] * left[i]);
            long b = (a * right[i]);
            ans = (ans + b) % mod;
            //ans = (ans + arr[i] * left[i] * right[i]) % mod;
            ans %= mod;
        }
        return (int) ans;
    }
}
