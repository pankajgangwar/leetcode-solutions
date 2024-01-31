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

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Queue<Jump> q = new PriorityQueue<>((j1,j2) -> j1.steps - j2.steps);
        q.offer(new Jump(0, false, 0));

        HashSet<Integer> notAllowed = new HashSet<>();
        int maxLimit = 2000 + 2 * b;
        for (int e : forbidden) {
            notAllowed.add(e);
            maxLimit = Math.max(maxLimit, e + 2 * b);
        }

        HashSet<String> visited = new HashSet<>();
        
        while (!q.isEmpty()) {
            Jump curr = q.poll();
            //if(curr.pos > maxLimit) return -1;
            //System.out.println("curr " + curr.pos);
            if (curr.pos == x) return curr.steps;
            int forward = curr.pos + a;
            int backward = curr.pos - b;

            String back = backward + "," + 0;
            if (!notAllowed.contains(backward) && !visited.contains(back) && 
                !curr.isBackWard && backward >= 0) {
                visited.add(back);
                q.offer(new Jump(backward, true, curr.steps + 1));
            }
            
            String forw = forward + "," + 1;
            if (!notAllowed.contains(forward) && !visited.contains(forw) && forward < maxLimit) {
                visited.add(forw);
                q.offer(new Jump(forward, false, curr.steps + 1));
            }
            
        }
        return -1;
    }
    
}
