class Solution {
    public boolean canPartitionKSubsets1(int[] nums, int k) {
        int targetSum = 0;
        int maxNum = 0;
        for(int x : nums){
            targetSum += x;
            maxNum = Math.max(maxNum, x);
        }
        if(targetSum % k != 0 || maxNum > targetSum / k){
            return false;
        }

        return helper(nums, k, new boolean[nums.length], 0, targetSum / k, 0);
    }
    
    public boolean canPartitionKSubsets(int[] nums, int k){
        int n = nums.length;
        if(n == 0) return false;
        int total = Arrays.stream(nums).sum();
        if(total % k != 0) return false;
        int side = total / k;
        Arrays.sort(nums);
        reverse(nums);
        if(nums[0] > side) return false;
        int[] bucket = new int[k];

        return helper(nums, 0, side, bucket);
    }

    public boolean helper(int[] nums, int idx, int target, int[] bucket){
        if(idx == nums.length){
            for(int x : bucket){
                if(x != target) return false;
            }
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            if(bucket[i] + nums[idx] > target) continue;
            bucket[i] += nums[idx];
            if(helper(nums, idx + 1, target, bucket)) return true;
            bucket[i] -= nums[idx];
        }
        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public boolean helper(int[] nums, int k, boolean[] visited, int curSum, int targetSum, int nextIndex){
        if(k == 0) return true;
        if(curSum == targetSum){
            return helper(nums, k - 1, visited, 0, targetSum, 0 );
        }

        for(int i = nextIndex; i < nums.length; i++){
            if (!visited[i] && curSum + nums[i] <= targetSum) {
                visited[i] = true;
                if (helper(nums, k, visited, curSum + nums[i], targetSum, i + 1)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}