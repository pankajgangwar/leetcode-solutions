class Solution {
    class TrieNode {
        boolean isEndOfWord = false;
        int count = 0;
        int TOTAL_ALPHABETS = 26;
        TrieNode[] children = new TrieNode[TOTAL_ALPHABETS];
        public TrieNode() {
            for (int i = 0; i < TOTAL_ALPHABETS; i++) {
                children[i] = null;
            }
        }
    }
    TrieNode root = new TrieNode();
    public void insert(String key){
        int level;
        TrieNode pCrawl = root;
        for(level = 0; level < key.length(); level++ ){
            int index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null){
                pCrawl.children[index] = new TrieNode();
            }
            pCrawl.children[index].count += 1;
            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    public int search(String key){
        int level;
        TrieNode pCrawl = root;
        int count = 0;
        for(level = 0 ; level < key.length(); level++){
            int index = key.charAt(level) - 'a';
            if(pCrawl.children[index] == null){
                return count;
            }
            count += pCrawl.children[index].count;
            pCrawl = pCrawl.children[index];
        }
        return count;
    }

    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            String w = words[i];
            insert(w);
        }
        for (int i = 0; i < n; i++) {
            String w = words[i];
            res[i] = search(w);
        }
        return res;
    }
}