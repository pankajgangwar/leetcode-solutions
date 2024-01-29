class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        return ifCanFinish(numCourses, prerequisites);
    }

    public boolean ifCanFinish(int n, int[][] dep) {
        int[] indegree = new int[n];
        int count = 0;
        HashMap<Integer, List<Integer>> g = new HashMap<>();

        for (int i = 0; i < dep.length; i++) {
            int v = dep[i][0];
            int u = dep[i][1];
            g.putIfAbsent(u, new LinkedList<>());
            g.get(u).add(v);

            indegree[dep[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                count++;
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int u = queue.poll();
                for (int v : g.getOrDefault(u, new LinkedList<>())) {
                    indegree[v]--;
                    if (indegree[v] == 0) {
                        count++;
                        queue.offer(v);
                    }
                }
            }
        }
        return n == count;
    }
}
