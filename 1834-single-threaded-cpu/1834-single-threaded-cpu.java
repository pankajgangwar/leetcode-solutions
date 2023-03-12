class Solution {
    public int[] getOrder(int[][] arr) {
        PriorityQueue<int[]> availableTask = new PriorityQueue<>((a,b) ->
                a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        int[][] tasks = new int[arr.length][3];
        for (int i = 0; i < arr.length; i++) {
            tasks[i] = new int[]{arr[i][0],arr[i][1],i};
        }
        Arrays.sort(tasks, (a,b) -> a[0] == b[0] ?
                (a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]) : a[0] - b[0]);
        int idx = 0;
        int resIdx = 0;
        int[] res =  new int[tasks.length];
        int time = 0;
        while (resIdx < tasks.length){
            while(idx < tasks.length && tasks[idx][0] <= time) {
                availableTask.offer(tasks[idx++]);
            }
            if(availableTask.isEmpty()){
                time = tasks[idx][0];
            }else{
                int[] bestFit = availableTask.poll();
                res[resIdx++] = bestFit[2];
                time += bestFit[1];
            }
            
        }
        return res;
    }
}