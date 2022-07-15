class Solution {
     class TrieNode {
        boolean isEndOfWord = false;
        int TOTAL_ALPHABETS = 26;
        TrieNode[] children = new TrieNode[TOTAL_ALPHABETS];
        List<String> list_words = new ArrayList<>(3);

        public TrieNode() {
            for (int i = 0; i < TOTAL_ALPHABETS; i++) {
                children[i] = null;
            }
        }
    }

    TrieNode root;
    
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        root = new TrieNode();
        for(String product : products) {
            addword(product);
        }

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < searchWord.length(); i++) {
            String search_sub = searchWord.substring(0, i + 1);
            List<String> all_sub_products = search(search_sub);
            result.add(all_sub_products);
        }
        return result;
    }

    public void addword(String word) {
        TrieNode pCrawl = root;
        int length = word.length();
        for (int level = 0; level < length; level++) {
            int idx = word.charAt(level) - 'a';
            if (pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode();
            }
            List<String> wordsWithThisChar = pCrawl.children[idx].list_words;
            if(wordsWithThisChar.size() < 3){
                wordsWithThisChar.add(word);
            }
            pCrawl = pCrawl.children[idx];
        }
        pCrawl.isEndOfWord = true;
    }
    
    public List<String> search(String word){
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if(node.children[ch - 'a'] == null)
                return new ArrayList<>();

            node = node.children[ch - 'a'];
        }
        return node.list_words;
    }
}