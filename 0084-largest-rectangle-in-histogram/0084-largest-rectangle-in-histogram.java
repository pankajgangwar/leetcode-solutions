class Solution {
    public int largestRectangleArea(int[] heights) {
        int i;
        int area = 0;
        int maxArea = 0;
        Stack<Integer> mStack = new Stack<>();

        for (i = 0; i < heights.length;) {
            if(mStack.isEmpty() || heights[mStack.peek()] <= heights[i]){
                mStack.push(i++);
            }else{
                int top = mStack.pop();
                if(mStack.isEmpty()){
                    area = heights[top] * i;
                }else{
                    area = heights[top] * (i - mStack.peek() - 1);
                }
                maxArea = Math.max(area, maxArea);
            }
        }

        while (!mStack.isEmpty()){
            int top = mStack.pop();
            if(mStack.isEmpty()){
                area = heights[top] * i;
            }else{
                area = heights[top] * (i - mStack.peek() - 1);
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}