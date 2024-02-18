class TrieNode {
        boolean isEndOfWord = false;
        TrieNode[] children = new TrieNode[26];
        public TrieNode(){
            for (int i = 0; i < 26 ; i++) {
                children[i] = null;
            }
        }
    }
    class WordDictionary {
    
        TrieNode root;
        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }
        
        /** Adds a word into the data structure. */
        public void addWord(String word) {
            int length = word.length();
            TrieNode pCrawl = root;
            for (int level = 0; level < length ; level++ ) {
                int idx = word.charAt(level) - 'a';
                if(pCrawl.children[idx] == null){
                    pCrawl.children[idx] = new TrieNode();
                }
                pCrawl = pCrawl.children[idx];
            }
            pCrawl.isEndOfWord = true;
        }
        
        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return searchRec(word, 0, root);
        }

        public boolean searchRec(String word, int idx, TrieNode pCrawl){
            if(word.length() == idx){
                return pCrawl != null && pCrawl.isEndOfWord;
            }
            if(word.charAt(idx) != '.'){
                pCrawl = pCrawl.children[word.charAt(idx) - 'a'];
                if(pCrawl != null && searchRec(word, idx + 1, pCrawl)){
                    return true;
                }else{
                    return false;
                }
            }else{
                for(int i = 0; i < pCrawl.children.length; i++){
                    if(pCrawl.children[i] != null ){
                        if(searchRec(word, idx + 1, pCrawl.children[i])){
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */