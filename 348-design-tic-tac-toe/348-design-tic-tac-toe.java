class TicTacToe {

    /** Initialize your data structure here. */
     char[][] board;
        int n;
        int[] rows;
        int[] cols;
        int diagonal;
        int antiDiagonal;
        public TicTacToe(int n) {
            board = new char[n][n];
            rows = new int[n];
            cols = new int[n];
            this.n = n;
        }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
            int toAdd = player == 1 ? 1 : -1;

            rows[row] += toAdd;
            cols[col] += toAdd;

            if(row == col){
                diagonal += toAdd;
            }
            if(col == (n - row - 1)){
                antiDiagonal += toAdd;
            }
            if(Math.abs(rows[row]) == n  || Math.abs(cols[col]) == n || Math.abs(diagonal) == n
                  || Math.abs(antiDiagonal) == n ){
                return player;
            }
            return 0;
        }

}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */