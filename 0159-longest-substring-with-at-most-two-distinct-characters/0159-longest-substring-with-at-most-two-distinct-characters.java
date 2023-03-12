class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        return lengthOfLongestSubstringKDistinct(s, 2);
    }
    
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();
        
        int counter = 0;

        int begin = 0, end = 0;

        int len = Integer.MAX_VALUE;

        while(end < s.length()){

            char c = s.charAt(end);

            map.put(c, map.getOrDefault(c, 0) + 1);

            if(map.get(c) == 1) counter++;

            end++;

            while(counter > k){

                char tempc = s.charAt(begin);
                map.put(tempc, map.get(tempc) - 1);
                if(map.get(tempc) == 0) counter--;
                begin++;
            }
            maxLength = Math.max(maxLength, end - begin);
        }
        return maxLength;
    }
}