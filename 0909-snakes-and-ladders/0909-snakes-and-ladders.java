class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n*n];
        Arrays.fill(arr, -1);
        boolean flip = false;
        int index = 0;
        for(int i = n-1; i >= 0; i--){
            if(flip){
                for(int j = n-1; j >= 0; j--){
                    index++;
                    if(board[i][j] != -1){
                        arr[index-1] = board[i][j] - 1;
                    }
                }
                flip = false;
            }else{
                for(int j = 0; j < n; j++){
                    index++;
                    if(board[i][j] != -1){
                        arr[index-1] = board[i][j] - 1;
                    }
                }
                flip = true;
            }
        }
        
        
        System.out.println(Arrays.toString(arr));

        Queue<Integer> bfs = new LinkedList<Integer>();
        
        int minSteps = 0;
        
        boolean[] visited = new boolean[arr.length];
        
        int start = arr[0] > -1 ? arr[0] : 0;
        
        visited[start] = true;
        bfs.offer(start);
        
        while(!bfs.isEmpty()){
            int size = bfs.size();
            while(size-- > 0){
                int loc = bfs.poll();
                if(loc == arr.length -1){
                    return minSteps;
                }

                for(int next = loc + 1; next <= Math.min(6 + loc, arr.length -1); next++){
                    int dest = arr[next] == -1 ? next : arr[next];
                    if(!visited[dest]){
                        visited[dest]= true;
                        //System.out.println(dest);
                        bfs.offer(dest);
                    }
                }
            }
            minSteps++;
        }
        return -1;
    }
}