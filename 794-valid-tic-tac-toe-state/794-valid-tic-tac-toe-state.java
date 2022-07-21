class Solution {
    public boolean validTicTacToe(String[] board) {
         int diag = 0, antiDiag = 0;
        int turns = 0;
        int n = 3;
        int[] rows = new int[n];
        int[] cols = new int[n];

        boolean xWin, OWin;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if(board[i].charAt(j) == 'X'){
                    turns++;
                    if(i == j) diag++;
                    if(i + j == 2) antiDiag++;
                    rows[i]++;
                    cols[j]++;
                }else if(board[i].charAt(j) == 'O'){
                    turns--;
                    rows[i]--;
                    cols[j]--;
                    if(i == j) diag--;
                    if(i + j == 2) antiDiag--;
                }
            }
        }

        xWin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3
                || cols[0] == 3 || cols[1] == 3 || cols[2] == 3
               || diag == 3 || antiDiag == 3;

        OWin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3
                || cols[0] == -3 || cols[1] == -3 || cols[2] == -3
                || diag == -3 || antiDiag == -3;

        if(xWin && turns == 0 || OWin && turns == 1) return false;

        return (turns == 0 || turns == 1);
    }
}