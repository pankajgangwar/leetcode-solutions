class Solution {
    public int[] findBuildings(int[] heights) {
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < heights.length; i++){
            int h = heights[i];
            while(!st.isEmpty() && heights[st.peek()] <= h){
                st.pop();
            }
            st.push(i);
        }
        int h = st.size();
        int[] res = new int[h];
        for(int i = h - 1; i >= 0; i--){
            res[i] = st.pop();
        }
        return res;
    }
}