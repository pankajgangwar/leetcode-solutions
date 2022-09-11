class Solution {
    
    public int shortestWay(String source, String target) {
        return shortestWayBFS(source, target);
    }
    
    public int shortestWayBFS(String source, String target) {
        for (int i = 0; i < target.length(); i++) {
            String ch = target.charAt(i)+ "";
            if(!source.contains(ch)){ // This character doesn't exists
                return -1;
            }
        }
        Queue<String> q = new LinkedList<>();
        q.offer(target);
        int min_steps = 0;
        while (!q.isEmpty()){
            String curr = q.poll();
            int i = 0, j = 0;
            while (i < curr.length() && j < source.length()){
                if(curr.charAt(i) == source.charAt(j)){
                    i++;
                }
                j++;
            }
            if(i < curr.length()){
                String rem = curr.substring(i);
                q.offer(rem);
            }
            if(i == curr.length()){
                break;
            }
            min_steps++;
        }
        System.out.println("min_steps = " + min_steps);
        return min_steps + 1;
    }
    
    public int shortestWayBinarySearch(String source, String target) {
        ArrayList<Integer>[] list = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < source.length(); i++) {
            list[source.charAt(i) - 'a'].add(i);
        }
        int res = 1, j = 0;
        for (int i = 0; i < target.length(); ) {
            int ch = target.charAt(i) - 'a';
            List<Integer> ids = list[ch];
            if(ids.isEmpty()){
                return -1;
            }
            int idx = Collections.binarySearch(ids, j);
            if(idx < 0) idx = ~idx;
            if(idx == ids.size()){
                res++;
                j = 0;
            }else{
                j = ids.get(idx) + 1;
                i++;
            }
        }
        return res;
    }
}