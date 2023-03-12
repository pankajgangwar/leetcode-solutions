class Solution {
    public List<List<Integer>> permute(int[] nums) {
	    	ArrayList<Integer> mResult = new ArrayList<>();
	    	findPermutationRec(nums, mResult);
	    	return all_permutations;
	    }
	    
	    List<List<Integer>> all_permutations = new ArrayList<>();
	    
	   public void findPermutationRec(int[] nums, ArrayList<Integer> result) {
	    	if(nums.length == result.size()) {
	    		all_permutations.add(new ArrayList<>(result));
	    		return;
	    	}
	    	for(int i = 0; i < nums.length; i++) {
	    		int ele = nums[i];
                if(result.contains(ele)) continue;
	    		result.add(ele);
	    		findPermutationRec(nums, result);
	    		result.remove(result.size()-1);
	    	}
	    }
}