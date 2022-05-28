class Solution {
    
     class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd = false;

        public void insert(String s, int idx) {
            if(idx == s.length()){
                isEnd = true;
                return;
            }
            int ch = s.charAt(idx) - 'a';
            if(children[ch] == null){
                children[ch] = new Trie();
            }
            children[ch].insert(s, idx + 1);
        }

        public boolean find(String s, int index, int diff) {
            if(diff > 1) return false;
            if(index == s.length()) return (diff == 1 && isEnd);
            int ch = s.charAt(index) - 'a';
            boolean res = children[ch] != null && children[ch].find(s, index + 1, diff);
            if(res) return true;
            for(Trie curr : children){
                if(curr != null && curr != children[ch]){
                    if(curr.find(s, index + 1, diff + 1)){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public boolean differByOne(String[] dict) {
        Trie root = new Trie();
        for(String s : dict){
            if(root.find(s, 0, 0)){
                return true;
            }
            root.insert(s,0);
        }
        return false;
    }
}