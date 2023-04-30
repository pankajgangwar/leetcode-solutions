class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
       int N = s.length();
        UnionFind unionFind = new UnionFind(N);
        for (List<Integer> swap : pairs) {
            unionFind.union(swap.get(0), swap.get(1));
        }
        Map<Integer, PriorityQueue<Character>> graph = new HashMap<>();

        for (int i = 0; i < N; i++) {
            int head = unionFind.find(i);
            PriorityQueue<Character> characters = graph.computeIfAbsent(head, (dummy) -> new PriorityQueue<>());
            characters.add(s.charAt(i));
        }


        StringBuilder sb = new StringBuilder(N);
        for (int i = 0; i < N ; i++) {
            PriorityQueue<Character> characters = graph.get(unionFind.find(i));
            char characterMin = characters.poll();
            sb.append(characterMin);
        }
        return sb.toString();
    }

    class UnionFind {
        public int[] size;
        public int[] parent;
        public UnionFind(int count){
            size = new int[count];
            parent = new int[count];
            for (int i = 0; i < count; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int p){
            while(p != parent[p]){
                parent[p] = parent[parent[p]];
                p = parent[p];
            }
            return p;
        }

        public int union(int p, int q){
            int pRoot = find(p);
            int qRoot = find(q);

            if(pRoot == qRoot){
                size[pRoot] += size[pRoot];
                parent[qRoot] = pRoot;
                return size[qRoot];
            }else{
                parent[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
                return size[qRoot];
            }
        }
    }
}