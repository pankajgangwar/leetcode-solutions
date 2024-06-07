class Solution {
    
   class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfTheWord = false;
        public TrieNode(){

        }
    }
    public void insert(String word, TrieNode root){
        for(int i = 0; i < word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(root.children[idx] == null){
                root.children[idx] = new TrieNode();
            }
            root = root.children[idx];
        }
        root.isEndOfTheWord = true;
    }
    public int search(String word, TrieNode root){
        int len = 0;
        for(int i = 0; i < word.length() && !root.isEndOfTheWord; i++){
            int idx = word.charAt(i) - 'a';
            if(root.children[idx] == null){
                return 0;
            }
            len += 1;
            root = root.children[idx];
        }
        return len;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();

        for(String d : dictionary){
            insert(d, root);
        }
        StringBuilder out = new StringBuilder();
        for(String s : sentence.split(" ")){
            int l = search(s, root);
            if(l == 0) {
                out.append(s).append(" ");
            }else{
                out.append(s, 0, l).append(" ");
            }
        }
        return out.toString().trim();
    }
    
}