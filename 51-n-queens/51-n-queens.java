class Solution {
        int N;
		List<List<String>> mList = new ArrayList<>();
		public List<List<String>> solveNQueens(int n) {
			this.N = n;
			int[][] board = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					board[i][j] = 0;
				}
			}
			solveNQUtil(board, 0);
			return mList;
		}

		public void solveNQUtil(int[][] board, int queen) {
			if (queen == N) {
				printSolution(board);
				return;
			}
			for (int i = 0; i < N; i++) {
				if (isSafeToMove(board, i, queen)) {
					board[i][queen] = 1;
					solveNQUtil(board, queen + 1);
					board[i][queen] = 0;
				}
			}
		}

		public boolean isSafeToMove(int[][] board, int rows, int cols) {
			int i,j;
			for(j = cols; j >= 0; j-- )
				if(board[rows][j] == 1)
					return false;
            for(j = cols; j < N; j++ )
				if(board[rows][j] == 1)
					return false;
			for(i = rows, j = cols; i >= 0 && j >= 0; i--, j-- )
				if(board[i][j] == 1)
					return false;
            for(i = rows, j = cols; i >= 0 && j < N; i--, j++ )
				if(board[i][j] == 1)
					return false;
			for(i = rows, j = cols; i < N && j >= 0; i++, j-- )
				if(board[i][j] == 1)
					return false;
            for(i = rows, j = cols; i < N && j < N; i++, j++ )
				if(board[i][j] == 1)
					return false;
			return true;
		}

		public void printSolution(int board[][]) {
			ArrayList<String> mcol = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				StringBuilder builder = new StringBuilder();
				for (int j = 0; j < N; j++) {
					if (board[i][j] == 1) {
						builder.append("Q");
					} else {
						builder.append(".");
					}
				}
				mcol.add(builder.toString());
			}
			mList.add(mcol);
		}
    
}