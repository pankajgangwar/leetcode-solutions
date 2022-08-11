class Solution {
     public boolean placeWordInCrossword(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[][]dirs = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == ' ' || board[i][j] == word.charAt(0)){
                    for(int[] dir : dirs){
                        int idx = 0;
                        int next_x = i;
                        int next_y = j;
                        if(isSafe(i - dir[0], j - dir[1], board) && board[i - dir[0]][j - dir[1]] != '#') continue;
                        while (idx < word.length() && isSafe(next_x, next_y, board)){
                            if(board[next_x][next_y] == '#' ||
                                    (board[next_x][next_y] != ' ' && board[next_x][next_y] != word.charAt(idx))){
                                break;
                            }
                            next_x += dir[0];
                            next_y += dir[1];
                            idx++;
                        }
                        if(idx == word.length() && (!isSafe(next_x, next_y, board) || board[next_x][next_y] == '#')) return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isSafe(int i, int j, char[][] board) {
        int n = board.length;
        int m = board[0].length;
        return (i >= 0 && j >= 0 && i < n && j < m);
    }
}