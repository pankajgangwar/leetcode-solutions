class TrieNode {
        boolean isEndOfWord = false;
        int TOTAL_ALPHABETS = 26;
        TrieNode[] children = new TrieNode[TOTAL_ALPHABETS];
        public TrieNode(){
            for(int i = 0; i < TOTAL_ALPHABETS; i++){
                children[i] = null;
            }
        }
    }

class Trie {

    /** Initialize your data structure here. */
    TrieNode root;                                                      
    public Trie() {
            root = new TrieNode();
        }
        
        /** Inserts a word into the trie. */
        public void insert(String word) {
            int n = word.length();
            TrieNode pCrawl = root;
            for (int level = 0; level < n ; level++ ) {
                int idx = word.charAt(level) - 'a';
                if(pCrawl.children[idx] == null){
                    pCrawl.children[idx] = new TrieNode();
                }
                pCrawl = pCrawl.children[idx];
            }
            pCrawl.isEndOfWord = true;
        }
        
        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode pCrawl = root;
            int length = word.length();

            for (int level = 0; level < length ; level++ ) {
                int idx = word.charAt(level) - 'a';
                if(pCrawl.children[idx] == null){
                    return false;
                }
                pCrawl = pCrawl.children[idx];
            }
            return (pCrawl != null && pCrawl.isEndOfWord);
        }
        
        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            int length = prefix.length();
            TrieNode pCrawl = root;
            for (int level = 0; level < length ; level++) {
                int idx = prefix.charAt(level) - 'a';
                if(pCrawl.children[idx] == null){
                    return false;
                }
                pCrawl = pCrawl.children[idx];
            }
            return true;
        }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */