class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s == null || s.length() == 0) {
            result.add("");
            return result;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(s);
        
        Set<String> visited = new HashSet<>();
        visited.add(s);
        
        boolean found = false;
         while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                String curr = q.poll();
                if(isValid(curr)){
                    result.add(curr);
                    found = true;
                }
                if(found) continue;
                for(int i = 0; i < curr.length(); i++){
                    if (curr.charAt(i) != '(' && curr.charAt(i) != ')') continue;
                        String expression = curr.substring(0, i) + curr.substring(i + 1);
                        if(!visited.contains(expression)){
                            q.offer(expression);
                            visited.add(expression);
                        }
                }
            }
        }
        return result;
    }
    
    public boolean isValid(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '(') count++;
            if(ch == ')' && count-- == 0)return false;
        }
        return count == 0;
    }
}