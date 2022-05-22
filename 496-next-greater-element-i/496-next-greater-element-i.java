class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for(int ele : nums2){
            while(!stack.isEmpty() && stack.peek() < ele)
                map.put(stack.pop(), ele);
            stack.push(ele);
        }

        for(int i = 0; i < nums1.length; i++){
            int ele = nums1[i];
            nums1[i] = map.getOrDefault(ele, -1);
        }

        return nums1;
    }
}