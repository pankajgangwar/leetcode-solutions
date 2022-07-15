class Solution {
    Set<String> found_words = new HashSet<>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfsTrie(board, i, j, "", trie, visited);
            }
        }

        return new ArrayList<String>(found_words);
    }
    
   private void dfsTrie(char[][] board, int i, int j, String str, Trie trie, boolean[][] visited) {
        int rows = board.length;
        int cols = board[0].length;

        if(i < 0 || i >= rows || j < 0 || j >= cols || visited[i][j])
            return;

        str = str + board[i][j];
        if(!trie.startsWith(str)){
            return;
        }
        if(trie.search(str)){
            found_words.add(str);
        }
        visited[i][j] = true;

        dfsTrie(board, i+1, j, str, trie, visited);
        dfsTrie(board, i, j+1, str, trie, visited);
        dfsTrie(board, i - 1, j, str, trie, visited);
        dfsTrie(board, i, j -1, str, trie, visited);

        visited[i][j] = false;
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        String item = "";
    }
    class Trie {
        public TrieNode root = new TrieNode();

        public void insert(String word){
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if(node.children[ch - 'a'] == null){
                    node.children[ch - 'a'] = new TrieNode();
                }
                node = node.children[ch - 'a'];
            }
            node.item = word;
        }

        public boolean search(String word){
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                if(node.children[ch - 'a'] == null)
                    return false;

                node = node.children[ch - 'a'];
            }
            if(node.item.equals(word)){
                return true;
            }else{
                return false;
            }
        }

        public boolean startsWith(String prefix){
            TrieNode node = root;
            for (char ch  : prefix.toCharArray()) {
                if(node.children[ch - 'a'] == null)
                    return false;
                node = node.children[ch - 'a'];
            }
            return true;
        }
    }
    
     public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean [][]visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(anotherWordDFS(board, word, i, j, 0,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
     public boolean anotherWordDFS(char[][] board, String word, int curr_x, int curr_y, int curr_index, boolean[][] visited){
        if(curr_index == word.length()){
            return true;
        }
        if(curr_x < 0 || curr_x >= board.length || curr_y < 0 || curr_y >= board[0].length
                || board[curr_x][curr_y] != word.charAt(curr_index) || visited[curr_x][curr_y]){
            return false;
        }

        visited[curr_x][curr_y] = true;

        boolean res = anotherWordDFS(board, word, curr_x + 1, curr_y, curr_index+1, visited) ||
        anotherWordDFS(board, word, curr_x , curr_y + 1, curr_index+1, visited) ||
        anotherWordDFS(board, word, curr_x - 1, curr_y, curr_index+1, visited) ||
        anotherWordDFS(board, word, curr_x , curr_y -1, curr_index+1, visited);

        visited[curr_x][curr_y] = false;

        return res;
    }
}