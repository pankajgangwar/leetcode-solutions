class Solution {
    
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean end;
        public TrieNode() {
            children = new HashMap<>();
        }
    }
    
    public boolean differByOne(String[] dict) {
        TrieNode root = buildTrie(dict);
        for (String w : dict) {
            if (search(root, w, 0, 0)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean search (TrieNode root, String w, int diff, int index) {
        if (diff > 1) {
            return false;
        }
        
        if (index >= w.length()) {
            return root.end && diff == 1;
        }
        
        char c = w.charAt(index);
        for (char key: root.children.keySet()) {
            if (key == c ) {
                if (search(root.children.get(key), w, diff, index+1)) {
                    return true;
                } 
            } else {
                if (search(root.children.get(key), w, diff+1, index+1)) {
                    return true;
                }
            }
        }
        return false;
        
    }
    
    public TrieNode buildTrie(String[] dict) {
        TrieNode root = new TrieNode();
        for (String word : dict) {
            TrieNode node = root;
            for (Character c : word.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    node.children.put(c, new TrieNode());
                } 
                node = node.children.get(c);
            }
            node.end = true;
        }
        return root;
    }
}