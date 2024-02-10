class Solution {
    
    public String longestNiceSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()){
            set.add(ch);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(set.contains(Character.toUpperCase(ch)) && set.contains(Character.toLowerCase(ch))) continue;
            String first = longestNiceSubstring(s.substring(0, i));
            String second = longestNiceSubstring(s.substring(i + 1));
            return first.length() >= second.length() ? first : second;
        }
        return s;
    }
    
     public int smallestStringFragment(String s) {
        char[] arr = s.toCharArray();
        int[] lower = new int[26];
        int[] upper = new int[26];
        Arrays.fill(lower, -1);
        Arrays.fill(upper, -1);

        int global_max = 0;
        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (Character.isUpperCase(ch)) {
                upper[ch - 'A'] = i;
            } else {
                lower[ch - 'a'] = i;
            }
            List<int[]> intervals = new ArrayList<>();
            for (int j = 0; j < 26; j++) {
                int start = Math.min(lower[j], upper[j]);
                int end = Math.max(lower[j], upper[j]);
                if (start == -1 && end == -1) {
                    continue;
                } else if (start == -1 || end == -1) {
                    intervals.clear();
                    break;
                }
                intervals.add(new int[] {start, end});
            }
            Collections.sort(intervals, Comparator.comparingInt(a -> a[0]));
            int curr_max = mergeIntervals(intervals);
            global_max = Math.max(global_max, curr_max);
        }
        System.out.println(global_max);
        return global_max;
    }

    public int mergeIntervals(List<int[]> intervals) {
        if (intervals.isEmpty()) return 0;
        Collections.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals.get(0);
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);// updated max end of interval
            } else {
                newInterval = interval;
                result.add(newInterval);//update end of this interval later
            }
        }
        int max_len = Integer.MAX_VALUE;
        for (int[] inter : result) {
            max_len = Math.min(max_len, inter[1] - inter[0]);
        }
        return max_len;
    }
}