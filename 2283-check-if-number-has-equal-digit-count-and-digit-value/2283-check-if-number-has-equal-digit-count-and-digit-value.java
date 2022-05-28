class Solution {
    public boolean digitCount(String num) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            map.put(digit, map.getOrDefault(digit, 0) + 1);
        }
        for (int i = 0; i < num.length(); i++) {
             int freq = num.charAt(i) - '0';
            if(map.containsKey(i) && map.get(i) != freq){
                return false;
            }
            if(!map.containsKey(i) && freq != 0) return false;
        }
        return true;
    }
}