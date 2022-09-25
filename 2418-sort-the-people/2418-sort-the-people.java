class Solution {
    class People {
        String name;
        int height;

        public People(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
    
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        People[] p = new People[n];
        for (int i = 0; i < n; i++) {
            p[i] = new People(names[i], heights[i]);
        }
        Arrays.sort(p, (a,b) -> b.height - a.height);
        for (int i = 0; i < n; i++) {
            names[i] = p[i].name;
        }
        return names;
    }
}