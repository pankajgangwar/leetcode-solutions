class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        
        int[] order = new int[numCourses];
        int index = 0;
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        
        for(int i = 0; i < prerequisites.length; i++){
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];
            
            g.putIfAbsent(u, new LinkedList<>());
            g.get(u).add(v);
            
            indegrees[prerequisites[i][0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0){
                order[index++] = i;
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            int u = queue.poll();
            for (int v : g.getOrDefault(u, new LinkedList<>())) {
                    indegrees[v]--;
                    if (indegrees[v] == 0) {
                        order[index++] = v;
                        queue.offer(v);
                    }
                }
             
        }
        return numCourses == index ? order : new int[0];
    }
    
    
    public int[] findOrderOldApproach(int numCourses, int[][] prerequisites) {
        Graph graph = buildGraphOfCourse(numCourses, prerequisites);

        Course[] courseOrder = checkCourseOrder(graph.getNodes());
        
        int[] courseArr = new int[courseOrder.length];
        int n = courseOrder.length -1;
        for (int i = courseOrder.length -1 ; i >= 0;  --i ) {
            courseArr[n - i] = courseOrder[i].getCourseNumber();
        }
        return courseArr;
    }

    public Course[] checkCourseOrder(List<Course> courseList){
        Course[] order = new Course[courseList.size()];

        int endOfList = addNonDependentCourse(order, courseList, 0);
        int toBeProcessed = 0;

        while(toBeProcessed < order.length){
            Course course = order[toBeProcessed];
            if(course == null){
                return new Course[0];
            }
            ArrayList<Course> children = course.getChildren();
            for(Course child : children){
                child.decrementDependency();
            }
            
            endOfList = addNonDependentCourse(order, courseList, endOfList);
            toBeProcessed++;
        }
        return order;

    }

    public int addNonDependentCourse(Course[] order, List<Course> courseList, int offset){
        for(Course course : courseList){
            if(course.getNumberOfDependencies() == 0){
                if(offset == courseList.size()){
                    return offset;
                }
                if(!course.isVisited()){
                    course.setVisited();
                    order[offset] = course;
                    ++offset;
                }
            }
        }
        return offset;
    }

    public Graph buildGraphOfCourse(int numCourses, int[][] prerequisites){
        Graph graph = new Graph();
        for (int i = 0; i < numCourses; ++i ) {
            graph.getOrCreateCourse(i);
        }

        for(int[] pre : prerequisites){
            graph.addEgde(pre[0], pre[1]);
        }

        return graph;
    }

    class Graph{
        ArrayList<Course> nodes = new ArrayList<>();
        HashMap<Integer, Course> map = new HashMap<>();

        public Course getOrCreateCourse(int course){
            if(map.containsKey(course)){
                return map.get(course);
            }else{
                Course courseObj = new Course(course);
                map.put(course, courseObj);
                nodes.add(courseObj);
                return courseObj;
            }
        }

        public void addEgde(int src, int dst){
            Course first = getOrCreateCourse(src);
            Course second = getOrCreateCourse(dst);
            first.addNeighbour(second);
        }

        public List<Course> getNodes(){
            return nodes;
        }
    }

    class Course {
        int dependencies;
        ArrayList<Course> list = new ArrayList<>();
        Map<Integer, Course> map = new HashMap<>();
        int courseNumber;
        boolean isVisited;

        public Course(int course){
            courseNumber = course;
        }

        public void addNeighbour(Course child){
            if(!map.containsKey(child.getCourseNumber())){
                map.put(child.getCourseNumber(), child);
                list.add(child);
                child.incrementDependency();
            }
        }

        public ArrayList<Course> getChildren(){
            return list;
        }
        
        public void setVisited(){
            isVisited = true;
        }
        public boolean isVisited(){
            return isVisited;
        }

        public int getCourseNumber(){
            return courseNumber;
        }

        public int getNumberOfDependencies(){
            return dependencies;
        }

        public void incrementDependency(){
            dependencies++;
        }
        public void decrementDependency(){
            dependencies--;
        }
    }
}