class Solution {
    public String[] expand(String s) {
        Queue<String> bfs = new LinkedList<>();
        ArrayList<String> res = new ArrayList<>();
        if(s.indexOf('{') < 0){
            return new String[]{s};
        }
        bfs.offer("");
        //abcd{a,b}c{d,e}f
        while(!bfs.isEmpty()){
            if(s.isEmpty()){
                break;
            }else if(s.charAt(0) == '{'){
                int start = 0;
                int end = s.indexOf("}");
                String options = s.substring(start + 1, end);
                s = s.substring(end + 1);
                String[] op = options.split(",");
                addToQueue(op, bfs);
            }else if(s.indexOf('{') < 0){
                addToQueue(new String[]{s}, bfs);
                s = "";
            }else{
                int start = s.indexOf("{");
                String a = s.substring(0, start);
                s = s.substring(start);
                addToQueue(new String[]{a}, bfs);
            }
        }
        int n = bfs.size();
        String [] ans = new String[n];
        for(int i = 0; i < n; i++){
            ans[i] = bfs.poll();
        }
        Arrays.sort(ans);
        return ans;
    }
    
    public void addToQueue(String[] arr, Queue<String> bfs){
        int  size = bfs.size();
        while(size-- > 0){
            String curr = bfs.poll();
            for(String a : arr){
                bfs.offer(curr + a);
            }
        }
    }
}