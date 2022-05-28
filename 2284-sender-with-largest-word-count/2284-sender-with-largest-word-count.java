class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = messages.length;
        for (int i = 0; i < n; i++) {
            String message = messages[i];
            String sender = senders[i];
            String[] words = message.split(" ");
            map.put(sender, map.getOrDefault(sender, 0) + words.length);
        }
        String res = senders[0];
        int max = Integer.MIN_VALUE;
        for(String sender : map.keySet()){
            int count = map.get(sender);
            if(max <= count){
                if(max < count) res = sender;
                max = count;
                if(res.compareTo(sender) < 0){
                    res = sender;
                }
            }
        }
        return res;
    }
}