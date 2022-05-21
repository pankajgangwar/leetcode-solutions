class Solution {

    public int countDistinct(String s) {
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
        return (n * (n + 1) / 2) - Arrays.stream(lcp).sum();
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
}
