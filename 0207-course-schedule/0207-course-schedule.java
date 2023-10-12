 class Solution {
		public boolean canFinish(int numCourses, int[][] prerequisites) {
			return ifCanFinish(numCourses, prerequisites);
			//return checkCourseOrder(graph.getNodes());
		}
     
      public boolean ifCanFinish(int n, int[][] dep){
        int[] indegree = new int[n];
        int count = 0;

        for(int i = 0; i < dep.length; i++){
            indegree[dep[i][0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                count++;
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size-- > 0){
                int course = queue.poll();
                for(int i = 0; i < dep.length; i++){
                    if(dep[i][1] == course){
                        indegree[dep[i][0]]--;
                        if(indegree[dep[i][0]] == 0){
                            count++;
                            queue.offer(dep[i][0]);
                        }
                    }
                }
            }
        }
        return n == count;
    }
     
 }
 


		