class Solution {
    public int longestRepeatingSubstring(String s) {
        //return usingBinarySearch(s);
        //return usingLCPConstructionNaive(s);
        return usingSuffixArray(s);
        /*SuffixArray sa = new SuffixArray(s);
        TreeSet<String> res = sa.lrs();
        System.out.println("sa.lrs(); = " + res);
        return res.isEmpty() ? 0 : res.first().length();*/
        //return usingRabinKarp(s);
    }
    
    public int usingRabinKarp(String s){
        int n = s.length();
        int low = 0, high = n - 1;
        int BASE = 26;
        long MOD = (long)Math.pow(2, 32);
        long[] pow = new long[n+1];
        pow[0] = 1L;
        for(int i = 1; i < n; ++i){
            pow[i] = pow[i-1] * BASE % MOD;
        }
        String maxRes = "";
        while (low <= high){
            int mid = low + (high - low) / 2;
            String res = search(s, mid, pow);
            if(res.length() > maxRes.length()){
                maxRes = res;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        int maxLen = maxRes.length();
        System.out.println("maxLen = " + maxRes);
        return maxLen;
    }

    public String search(String s, int len, long[] POW){
        if(len == 0) return "";
        int BASE = 26;
        long MOD = (long)Math.pow(2, 32);
        long curr = 0;
        int n = s.length();
        for (int i = 0; i < len; i++) {
            curr = (curr * BASE + (s.charAt(i) - 'a'))% MOD;
        }
        HashSet<Long> seen = new HashSet<>();
        seen.add(curr);
        for (int i = len; i < n; i++) {
            curr = ((curr - ((s.charAt(i - len) - 'a') * POW[len - 1])) % MOD + MOD) % MOD;
            curr = (curr * BASE + (s.charAt(i) - 'a')) % MOD;
            if(seen.contains(curr)){
                return s.substring(i - len, i);
            }
            seen.add(curr);
        }
        return "";
    }
    
    public int usingBinarySearch(String s){
        int n = s.length();
        int left = 1;
        int right = n;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(search(s, mid) != -1) left = mid + 1;
            else right = mid - 1;
        }
        return left - 1;
    }

    private int search(String s, int mid) {
        int n = s.length();
        HashSet<Long> seen = new HashSet<>();
        for (int i = 0; i < n - mid + 1; i++) {
            long hash = s.substring(i, i + mid).hashCode();
            if(!seen.add(hash)) return i;
        }
        return -1;
    }
    
    //https://cp-algorithms.com/string/suffix-array.html
    
    public static class SuffixArray {
        // ALPHABET_SZ is the default alphabet size, this may need to be much larger
        int ALPHABET_SZ = 256, N;
        int[] T, lcp, sa, sa2, rank, tmp, c;

        public SuffixArray(String str) {
            this(toIntArray(str));
        }

        private static int[] toIntArray(String s) {
            int[] text = new int[s.length()];
            for (int i = 0; i < s.length(); i++) text[i] = s.charAt(i);
            return text;
        }

        // Designated constructor
        public SuffixArray(int[] text) {
            T = text;
            N = text.length;
            sa = new int[N];
            sa2 = new int[N];
            rank = new int[N];
            c = new int[Math.max(ALPHABET_SZ, N)];
            construct();
            kasai();
        }

        private void construct() {
            int i, p, r;
            for (i = 0; i < N; ++i) c[rank[i] = T[i]]++;
            for (i = 1; i < ALPHABET_SZ; ++i) c[i] += c[i - 1];
            for (i = N - 1; i >= 0; --i) sa[--c[T[i]]] = i;
            for (p = 1; p < N; p <<= 1) {
                for (r = 0, i = N - p; i < N; ++i) sa2[r++] = i;
                for (i = 0; i < N; ++i) if (sa[i] >= p) sa2[r++] = sa[i] - p;
                Arrays.fill(c, 0, ALPHABET_SZ, 0);
                for (i = 0; i < N; ++i) c[rank[i]]++;
                for (i = 1; i < ALPHABET_SZ; ++i) c[i] += c[i - 1];
                for (i = N - 1; i >= 0; --i) sa[--c[rank[sa2[i]]]] = sa2[i];
                for (sa2[sa[0]] = r = 0, i = 1; i < N; ++i) {
                    if (!(rank[sa[i - 1]] == rank[sa[i]]
                            && sa[i - 1] + p < N
                            && sa[i] + p < N
                            && rank[sa[i - 1] + p] == rank[sa[i] + p])) r++;
                    sa2[sa[i]] = r;
                }
                tmp = rank;
                rank = sa2;
                sa2 = tmp;
                if (r == N - 1) break;
                ALPHABET_SZ = r + 1;
            }
        }

        // Use Kasai algorithm to build LCP array
        private void kasai() {
            lcp = new int[N];
            int[] inv = new int[N];
            for (int i = 0; i < N; i++) inv[sa[i]] = i;
            for (int i = 0, len = 0; i < N; i++) {
                if (inv[i] > 0) {
                    int k = sa[inv[i] - 1];
                    while ((i + len < N) && (k + len < N) && T[i + len] == T[k + len]) len++;
                    lcp[inv[i] - 1] = len;
                    if (len > 0) len--;
                }
            }
        }

        // Finds the LRS(s) (Longest Repeated Substring) that occurs in a string.
        // Traditionally we are only interested in substrings that appear at
        // least twice, so this method returns an empty set if this is not the case.
        // @return an ordered set of longest repeated substrings
        public TreeSet<String> lrs() {
            int max_len = 0;
            TreeSet<String> lrss = new TreeSet<>();

            for (int i = 0; i < N; i++) {
                if (lcp[i] > 0 && lcp[i] >= max_len) {

                    // We found a longer LRS
                    if (lcp[i] > max_len) lrss.clear();

                    // Append substring to the list and update max
                    max_len = lcp[i];
                    lrss.add(new String(T, sa[i], max_len));
                }
            }
            return lrss;
        }
    }
    
    class Suffix implements Comparable<Suffix>{
        final int orgIdx;
        final String suffix;
        final int len;
        public Suffix(String suffix, int orgIdx){
            this.len = suffix.length();
            this.orgIdx = orgIdx;
            this.suffix = suffix;
        }

        @Override
        public int compareTo(Suffix other) {
            if (this == other) return 0;
            int min_len = Math.min(len, other.len);
            for (int i = 0; i < min_len; i++) {
                char otherCh = other.suffix.charAt(i);
                char thisCh = suffix.charAt(i);
                if (thisCh < otherCh) return -1;
                if (thisCh > otherCh) return 1;
            }
            return len - other.len;
        }

        @Override
        public String toString() {
            return new String(suffix.toCharArray(), orgIdx, len);
        }
    }

    public int usingSuffixArray(String s){
        int n = s.length();
        Suffix[] suffixArray = new Suffix[n];
        for (int i = 0; i < s.length(); i++) {
            suffixArray[i] = new Suffix(s.substring(i), i);
        }
        Arrays.sort(suffixArray);

        int[] sa = new int[n];
        for (int i = 0; i < n; i++) {
            sa[i] = suffixArray[i].orgIdx;
        }

        //int[] lcp = constructLcpUsingKasai(n, s, sa);
        int[] lcp = constructLcpNaive(n, suffixArray);
        int maxLen = Arrays.stream(lcp).max().getAsInt();
        return maxLen;
    }
    
    public int[] constructLcpUsingKasai(int n, String s, int[] sa){
        // LCP Construction using kasai algorithm
        int[] lcp = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[sa[i]] = i;
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            if (rank[i] == n - 1) {
                k = 0;
                continue;
            }
            int j = sa[rank[i] + 1];
            while (i + k < n && j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            lcp[rank[i]] = k;
            k = Math.max(k - 1, 0);
        }
        return lcp;
    }
    
    public int[] constructLcpNaive(int n, Suffix[] suffixArray){
        int[] lcp = new int[n];
        lcp[0] = 0;
        for (int i = 1; i < suffixArray.length; i++) {
            String prev = suffixArray[i-1].suffix;
            String curr = suffixArray[i].suffix;
            int currLCP = 0;
            for(int j = 0; j < Math.min(prev.length(), curr.length()); j++){
                if(prev.charAt(j) == curr.charAt(j)){
                    currLCP++;
                }else{
                    break;
                }
            }
            lcp[i] = currLCP;
        }
        return lcp;
    }
    
}