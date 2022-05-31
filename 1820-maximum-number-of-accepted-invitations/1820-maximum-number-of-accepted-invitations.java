class Solution {
    
    /*
     Max flow - Ford-Fulkerson | Network Flow
     Maximum Bipartite matching
    */

    public int maximumInvitations(int[][] grid) {
        int boys = grid.length;
        int girls = grid[0].length;
        int[] girlFixed = new int[girls];
        Arrays.fill(girlFixed, -1);
        int invitations = 0;
        for (int i = 0; i < boys; i++) {
            if (match(i, new HashSet<>(), grid, girlFixed)) {
                ++invitations;
            }
        }
        return invitations;
    }

    
    public boolean match(int boy, HashSet<Integer> seenGirl, int[][] grid, int[] girlFixed) {
        int m = grid.length; // boys
        int n = grid[0].length; // girls

        for (int g = 0; g < n; g++) {
            if(grid[boy][g] == 1 && !seenGirl.contains(g)){
                seenGirl.add(g);
                if(girlFixed[g] == -1 || match(girlFixed[g], seenGirl, grid, girlFixed)){
                    girlFixed[g] = boy;
                    return true;
                }
            }
        }
        return false;
    }
}
