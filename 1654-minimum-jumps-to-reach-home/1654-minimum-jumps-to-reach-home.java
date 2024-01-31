class Jump {
    int pos;
    boolean isBackWard;
    int steps;

    public Jump(int pos, boolean isBackWard, int steps) {
        this.pos = pos;
        this.isBackWard = isBackWard;
        this.steps = steps;
    }
}

class Solution {

    public int minimumJumps1(int[] forbidden, int a, int b, int x) {
        Queue<Jump> q = new PriorityQueue<>((j1,j2) -> j1.steps - j2.steps);
        q.offer(new Jump(0, false, 0));

        HashSet<Integer> notAllowed = new HashSet<>();
        for (int e : forbidden) {
            notAllowed.add(e);
        }

        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        int maxLimit = 2000 + 2 * b;
        
        while (!q.isEmpty()) {
            Jump curr = q.poll();
            if(curr.pos > maxLimit) return -1;
            //System.out.println("curr " + curr.pos);
            if (curr.pos == x) return curr.steps;
            int forward = curr.pos + a;
            int backward = curr.pos - b;

            if (!notAllowed.contains(backward) && !visited.contains(backward) && 
                !curr.isBackWard && backward >= 0) {
                visited.add(backward);
                q.offer(new Jump(backward, true, curr.steps + 1));
            }
            
            if (!notAllowed.contains(forward) && !visited.contains(forward)) {
                visited.add(forward);
                q.offer(new Jump(forward, false, curr.steps + 1));
            }
            
        }
        return -1;
    }
    
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1,a2)-> a1[0] - a2[0]);
        pq.offer(new int[]{0,0,0});//step, current index, direction(0 is back, 1 is forward)
        Set<Integer> forbit = new HashSet<>();
        Set<String> visited = new HashSet<>();
        int maxLimit = 2000 + 2 * b;
        for(int num : forbidden){
            forbit.add(num);
            maxLimit = Math.max(maxLimit, num + 2 * b);
        }
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int step = node[0];
            int idx = node[1];
            int dir = node[2];
            if(idx == x) return step;
			//try jump forward
            if(idx+a < maxLimit && !forbit.contains(idx+a) && !visited.contains(idx+a+","+0)){
                visited.add(idx+a+","+0);
                pq.offer(new int[]{step+1, idx+a, 0});
            }
			//try jump back
            if(idx-b >= 0 && !forbit.contains(idx-b) && !visited.contains(idx-b+","+1) && dir != 1){
                visited.add(idx-b+","+1);
                pq.offer(new int[]{step+1, idx-b, 1});
            }
        }
        return -1;
    }
}
