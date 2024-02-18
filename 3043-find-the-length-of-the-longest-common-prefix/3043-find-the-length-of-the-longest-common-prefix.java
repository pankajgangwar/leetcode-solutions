class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {

        TrieNode root = new TrieNode();
        for (int i = arr2.length - 1; i >= 0 ; i--) {
            insert(root, arr2[i]);
        }

        int max = 0;
        for (int i = arr1.length - 1; i >= 0 ; i--) {
            max = Math.max(max, search(root, arr1[i]));
        }
        
        root = new TrieNode();
        for (int i = arr1.length - 1; i >= 0 ; i--) {
            insert(root, arr1[i]);
        }

        for (int i = arr2.length - 1; i >= 0 ; i--) {
            max = Math.max(max, search(root, arr2[i]));
        }
        return max;
    }
    
    class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord = false;
        public TrieNode(){
            children = new TrieNode[10];
        }
    }

    public int search(TrieNode root, int n){
        String s = String.valueOf(n);
        TrieNode r = root;
        for (int i = 0; i < s.length(); i++) {
            int d = (int)s.charAt(i) - '0';
            if(r.children[d] != null){
                r = r.children[d];
            }else{
                return i;
            }
        }
        return r.isEndOfWord ? s.length() : 0;
    }

    public void insert(TrieNode root, int n){
        String s = String.valueOf(n);
        TrieNode r = root;
        for(char ch : s.toCharArray()){
            int d = (int)ch - '0';
            if(r.children[d] == null){
                r.children[d] = new TrieNode();
            }
            r = r.children[d];
        }
        r.isEndOfWord = true;
    }
}