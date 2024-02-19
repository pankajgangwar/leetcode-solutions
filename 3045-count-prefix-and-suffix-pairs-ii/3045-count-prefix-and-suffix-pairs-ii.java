class Solution {
     class TrieNode {
        HashMap<Integer, TrieNode> children = new HashMap<>();
        int count = 0;
    }

    public long countPrefixSuffixPairs(String[] words) {
        long max = 0;
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode x = root;
            int n = w.length();
            for(int i = 0; i < w.length(); i++){
                char first = w.charAt(i);
                char last = w.charAt(n - i - 1);
                int key = first * 128 + last;
                x = x.children.computeIfAbsent(key, _ -> new TrieNode());
                //x = x.children.computeIfAbsent(key, _ -> new TrieNode());
                max += x.count;
            }
            x.count++;
        }
        return max;
    }
}