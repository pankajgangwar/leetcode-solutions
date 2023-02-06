class Solution {
    public int reversePairs(int[] nums) {
        return reversePairsBIT(nums);
        //return reversePairsBST(nums);
    }
    
    public int reversePairsBIT(int[] nums) {
        int res = 0;
        int[] copy = Arrays.copyOf(nums, nums.length);
        int[] bit = new int[copy.length + 1];
        Arrays.sort(copy);
        
        for(int ele : nums){
            res += search(bit, findIndex(copy, 2L * ele + 1));
            insert(bit, findIndex(copy, ele));
        }
        return res;
    }
    
    public int findIndex(int[] copy, long val){
        int l = 0, r = copy.length -1, m = 0;
        while(l <= r){
            m = l + ((r - l) >> 1);
            if(copy[m] >= val ){
                r = m -1;
            }else{
                l = m +1;
            }
        }
        return l + 1;
    }
    
    public int search(int[] bit, int idx){
        int sum = 0;
        while(idx < bit.length){
            sum += bit[idx];
            idx += idx & -idx;
        }
        return sum;
    }
    
    public void insert(int[] bit, int i){
        while(i > 0){
            bit[i] += 1;
            i -=  i & -i;
        }
    }
    
    public int reversePairsBST(int[] nums) {
        int res = 0;
        TreeNode root = null;
        for(int ele : nums){
            res += search(root, 2L * ele + 1);
            root = insert(root, ele);
        }
        return res;
    }
    
    class TreeNode{
        int cnt, val;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int val){
            this.val = val;
            this.cnt = 1;
        }
    }
    
    public TreeNode insert(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }else if(root.val == val){
            root.cnt++;   
        }else if(root.val < val){
            root.cnt++;
            root.right = insert(root.right, val);
        }else{
            root.left = insert(root.left, val);
        }
        return root;
    }
    
    public int search(TreeNode root, long val){
        if(root == null){
            return 0;
        }else if(root.val == val){
            return root.cnt;
        }else if(root.val < val){
            return search(root.right, val);
        }else{
            return root.cnt + search(root.left, val);
        }
    }
    
}