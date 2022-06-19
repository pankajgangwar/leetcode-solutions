class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> mNum = new ArrayList<>();
        for ( int ele: nums) {
            mNum.add(ele);
        }
        subsetsRec(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void subsetsRec(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start){
         result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            subsetsRec(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    
}