class Solution {
    public int findCircleNum(int[][] M) {
        int[] root = new int[M.length];
        for(int i = 0; i < root.length; i++){
            root[i] = i;
        }

        for(int i = 0; i < M.length; i++){
            for(int j = 0; j < M[0].length; j++){
                if(M[i][j] == 1) {
                    int xRoot = findParent(root, i);
                    int yRoot = findParent(root, j);
                    if(xRoot != yRoot){
                        root[xRoot] = yRoot;
                    }
                }
            }            
        }

        int friend_circles = 0;
        for(int i = 0; i < root.length; i++ ){
            if(root[i] == i){
                friend_circles++;
            }
        }
        return friend_circles;
    }

    public int findParent(int[] root, int i){
        while(root[i] != i){
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
}