class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        for (int i = 0; i < numbers.length; i++) {
			int a = numbers[i];
			int bIdx = Arrays.binarySearch(numbers, target - a);
			if(bIdx != i && bIdx >= 0){
                int[] res = new int[]{bIdx+1, i+1};
                Arrays.sort(res);
                return res;
            }
		}
		return new int[] { -1, -1 };
    }
    
}