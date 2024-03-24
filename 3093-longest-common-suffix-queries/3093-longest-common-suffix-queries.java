class Solution {
     class TrieNode {
        TrieNode[] children;
        int minLen = Integer.MAX_VALUE;
        int index = -1;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    public int search(TrieNode root, String s){
        TrieNode r = root;
        int prev = -1;
        //System.out.println(" ***** search ***** " + s);
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if(r.children[idx] != null){
                //System.out.println( " ch " + ch + " idx " + r.index);
                prev = r.children[idx].index;
                r = r.children[idx];
            }else{
                return prev;
            }
        }
        return prev;
    }

    public void insert(TrieNode root, String s, int index){
        TrieNode r = root;
        for(char ch : s.toCharArray()){
            int idx = ch - 'a';
            if(r.children[idx] == null){
                r.children[idx] = new TrieNode();
            }
            if(r.children[idx].minLen > s.length()){
                r.children[idx].index = index;
                r.children[idx].minLen = s.length();
            }
            //System.out.println("char " + ch + " min " +  r.minLen + " idx " + r.index);
            r = r.children[idx];
        }
    }

    public int[] stringIndices(String[] A, String[] B) {
        TrieNode root = new TrieNode();

        int globalMin = Integer.MAX_VALUE;
        int globalMinIndex = -1;
        for (int i = 0; i < A.length; i++) {
            StringBuilder rev = new StringBuilder(A[i]).reverse();
            insert(root, rev.toString(), i);
            if(globalMin > A[i].length()){
                globalMin = A[i].length();
                globalMinIndex = i;
            }
        }

        int[] res = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            StringBuilder rev = new StringBuilder(B[i]).reverse();
            int ans = search(root, rev.toString());
            if(ans == -1){
                ans = globalMinIndex;
            }
            res[i] = ans;
        }
        return res;
    }
}