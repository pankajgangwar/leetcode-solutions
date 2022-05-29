class Solution {
    public int racecar(int target) {
        Queue<int[]> bfs = new LinkedList<>();
        int[] start = new int[]{0,1};
        bfs.offer(start); // pos, speed
        int level = 0;
        HashSet<String> visited = new HashSet<>();
        visited.add(Arrays.toString(start));
        while (!bfs.isEmpty()){
            int size = bfs.size();
            while (size-- > 0){
                int[] curr = bfs.poll();
                if(curr[0] == target) return level;
                int[] op1 = new int[]{curr[0] + curr[1], curr[1] * 2};
                int[] op2 = new int[]{curr[0], curr[1] > 0 ? -1 : 1};
                if(Math.abs(op1[0] - target) < target && !visited.contains(Arrays.toString(op1))){
                    visited.add(Arrays.toString(op1));
                    bfs.offer(op1);
                }
                if(Math.abs(op2[0] - target) < target && !visited.contains(Arrays.toString(op2))){
                    visited.add(Arrays.toString(op2));
                    bfs.offer(op2);
                }
            }
            level += 1;
        }
        return 0;
    }

}