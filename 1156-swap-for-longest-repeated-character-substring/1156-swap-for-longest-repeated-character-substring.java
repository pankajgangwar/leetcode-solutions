class Solution {
    public int maxRepOpt1(String text) {
        int maxLen = 0;
        HashMap<Character, LinkedList<Integer>> map = new HashMap<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            map.putIfAbsent(ch, new LinkedList<>());
        }
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            map.get(ch).add(i);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            LinkedList<Integer> list = map.get(ch);
            int count = 1, count1 = 0, max = 0;
            for (int i = 1; i < list.size(); i++) {
                if(list.get(i) == list.get(i-1) + 1){
                    count += 1;
                }else{
                    count1 = (list.get(i) == list.get(i-1) + 2) ? count : 0;
                    count = 1;
                }
                max = Math.max(max, count + count1);
            }
            maxLen = Math.max(maxLen, max + (list.size() > max ? 1 : 0));
        }
        return maxLen;
    }
}