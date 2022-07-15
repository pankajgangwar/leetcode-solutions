class Solution {
    public int largestVariance1(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        int maxVariance = 0;
        for (int a = 0; a < 26; a++) {
            for (int b = 0; b < 26; b++) {
                int max = freq[a];
                int min = freq[b];
                if(a == b || max == 0 || min == 0) continue;
                int currMax = 0, currMin = 0;
                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i) - 'a' == a ){
                        currMax++;
                    }
                    if(s.charAt(i) - 'a' == b){
                        currMin++;
                        min--;
                    }
                    if(currMin > 0){
                        maxVariance = Math.max(maxVariance, currMax - currMin);
                    }
                    if(currMax < currMin && min >= 1){
                        currMax = 0;
                        currMin = 0;
                    }
                }
            }
        }
        return maxVariance;
    }
    
    public int largestVariance(String s) {
        return maxDeviation(s);
    }
    
    public int maxDeviation(String str) {
        int ans = 0;
        for (char ch1 = 'a'; ch1 <= 'z'; ch1++) {
            for (char ch2 = 'a'; ch2 <= 'z'; ch2++) {
                if (ch1 == ch2) {
                    continue;
                }
                LinkedList<Integer> list = new LinkedList<>();
                for (char ch : str.toCharArray()) {
                    if (ch == ch1) {
                        if (!list.isEmpty() && list.peekLast() != -1) {
                            list.addLast(list.pollLast() + 1);
                        } else {
                            list.add(1);
                        }
                    } else if (ch == ch2) {
                        list.addLast(-1);
                    }
                }
                int sum = modifiedKadanes(list.stream().mapToInt(i -> i).toArray(), 2);
                if(sum > ans ){
                    ans = sum;
                }
            }
        }
        return ans;
    }

    public static int modifiedKadanes(int[] arr, int k) {
        int[] maxSum = new int[arr.length];
        int n = arr.length;
        if(n < k) return 0;
        // use kadane's
        maxSum[0] = arr[0];
        for (int i = 1 ; i < arr.length; i++) {
            maxSum[i] = Math.max(arr[i], maxSum[i - 1] + arr[i]);
        }

        int sum = 0 ;
        for (int i = 0 ; i < k; i++) {
            sum += arr[i];
        }

        int ans = sum;
        for (int i = k ; i < arr.length; i++) {
            sum = sum + arr[i] - arr[i - k];
            ans = Math.max(ans, sum);
            ans = Math.max(ans, sum + maxSum[i - k]);
        }
        return ans;
    }
    
}