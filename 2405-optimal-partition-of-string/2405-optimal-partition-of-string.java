class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(set.contains(ch)){
                set.clear();
                count += 1;
            }
            set.add(ch);
        }
        return count;
    }
}