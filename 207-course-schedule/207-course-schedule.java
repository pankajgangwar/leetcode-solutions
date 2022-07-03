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


		public Graph buildGraphOfCourses(int numCourses, int[][] prerequisites) {
			Graph graph = new Graph();
			for (int i = 0; i < numCourses; i++) {
				graph.getOrCreateCourse(i);
			}

			for (int[] dependency : prerequisites) {
				int first = dependency[0];
				int second = dependency[1];
				System.out.println(first + " --> " + second);
				graph.addEgde(first, second);
			}

			return graph;
		}

		public boolean checkCourseOrder(ArrayList<Course> courseList) {

			Course[] order = new Course[courseList.size()];

			int endOfList = addNonDependent(order, courseList, 0);
			int toBeProcessed = 0;
			//System.out.println("endOfList " + endOfList);

			while (toBeProcessed < order.length) {
				

				Course course = order[toBeProcessed];
				//There was no course found with 0 dependencies
				if (course == null) {
					return false;
				}

				ArrayList<Course> children = course.getChildren();
				for (Course child : children) {

					child.decrementDependencies();
				}

				endOfList = addNonDependent(order, courseList, endOfList);
				toBeProcessed++;
			}

			return true;

		}

		public int addNonDependent(Course[] order, ArrayList<Course> courseList, int offset) {
			
			for (Course course : courseList) {
				if (course.getNumberOfDependencies() == 0) {
					if(offset == order.length) {
						return offset;
					}
					if(!course.isVisited()) {
						course.setVisited();
						order[offset] = course;
						offset++;
					}
				}
			}
			return offset;
		}
	}

	 class Graph {
		ArrayList<Course> nodes = new ArrayList<Course>();
		HashMap<Integer, Course> map = new HashMap<>();

		public Course getOrCreateCourse(int course) {
			if (!map.containsKey(course)) {
				Course courseObj = new Course(course);
				map.put(course, courseObj);
				nodes.add(courseObj);
			}
			return map.get(course);
		}

		public void addEgde(int src, int dst) {
			Course start = getOrCreateCourse(src);
			Course end = getOrCreateCourse(dst);
			start.addNeighbour(end);
		}

		public ArrayList<Course> getNodes() {
			return nodes;
		}
	}

	 class Course {
		int dependencies;
		ArrayList<Course> list = new ArrayList<>();
		HashMap<Integer, Course> map = new HashMap<>();
		int course;
        boolean isVisited;

		public Course(int courseNumber) {
			course = courseNumber;
		}

		public void addNeighbour(Course child) {
			if (!map.containsKey(child.getCourseNumber())) {
				map.put(child.getCourseNumber(), child);
				list.add(child);
				child.incrementDependencies();
			}
		}
         
        public void setVisited() {
			isVisited = true;
		}
		
		public boolean isVisited() {
			return isVisited;
		}

		public ArrayList<Course> getChildren() {
			return list;
		}

		public void incrementDependencies() {
			dependencies++;
		}

		public void decrementDependencies() {
			dependencies--;
		}

		public int getNumberOfDependencies() {
			return dependencies;
		}

		public int getCourseNumber() {
			return course;
		}

}