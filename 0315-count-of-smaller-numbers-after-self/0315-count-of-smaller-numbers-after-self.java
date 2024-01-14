class Solution {
    
    class TreeNode {
        TreeNode left = null;
        TreeNode right = null;
        int sum, val, dup = 1;
        public TreeNode(int val, int prefixSum){
            this.sum = prefixSum;
            this.val = val;
        }
    }
    public List<Integer> countSmallerBST(int[] nums) {
        int n = nums.length;
        Integer[] res = new Integer[n];
        TreeNode root = null;
        for(int i = n -1; i >= 0; --i){
            root = insert(nums[i], root, res, i, 0);
        }

        return Arrays.asList(res);
    }

    public TreeNode insert(int val, TreeNode node, Integer[] res, int i, int prefixSum){
        if(node == null){
            node = new TreeNode(val, 0);
            res[i] = prefixSum;
        }else if(node.val > val){
            node.sum++;
            node.left = insert(val, node.left, res, i, prefixSum);
        }else if(node.val == val){
            node.dup++;
            res[i] = prefixSum + node.sum;
        }else{
            node.right = insert(val, node.right, res, i, prefixSum + node.dup + node.sum);
        }
        return node;
    }
    
    class Pair {
        int val, idx;
        public Pair(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }

    public List<Integer> countSmallerMSort(int[] nums) {
        int n = nums.length;
        Pair[] arr = new Pair[n];

        for(int i = 0; i < n; i++){
            Pair p = new Pair(nums[i], i);
            arr[i] = p;
        }

        Integer[] res = new Integer[n];
        Arrays.fill(res, 0);
        
        mergeSort(arr, res);
        
        for(Pair p : arr){
           // System.out.print(p.val + "\t");
        }

        return Arrays.asList(res);
    }

    public Pair[] mergeSort(Pair[] nums, Integer[] res){
        if(nums.length <= 1){
            return nums;
        }
        int mid = nums.length / 2;
        Pair[] left = mergeSort(Arrays.copyOfRange(nums, 0, mid), res);
        Pair[] right = mergeSort(Arrays.copyOfRange(nums, mid, nums.length), res);

        for(int i = 0, j = 0; i < left.length || j < right.length;){
            if(j == right.length || i < left.length && left[i].val <= right[j].val){
                nums[i + j] = left[i];
                res[left[i].idx] += j;
                i++;
            }else{
                nums[i + j] = right[j];
                j++;
            }
        }
        return nums;
    }
    
   public List<Integer> countSmallerNotSoGreat(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        Integer[] res = new Integer[nums.length];
       
        Arrays.fill(res, 0);
       
        for (int i = nums.length -1; i >= 0; --i) {
            int expectedIdx = Collections.binarySearch(list, nums[i]);
            if(expectedIdx < 0){
                expectedIdx = Math.abs(expectedIdx) - 1;
                list.add(expectedIdx, nums[i]);
                res[i] = expectedIdx;
            }
        }
        return Arrays.asList(res);
    }
    
    
     public List<Integer> countSmallerHeapTLE(int[] nums){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> tmpHeap = new PriorityQueue<>();

        List<Integer> res = new ArrayList<>(); 
        for(int i = nums.length - 1; i >= 0; --i){
            while(!minHeap.isEmpty() && minHeap.peek() < nums[i]){
                tmpHeap.offer(minHeap.poll());
            }
            res.add(0, tmpHeap.size());

            while(!tmpHeap.isEmpty()){
                minHeap.offer(tmpHeap.poll());
            }
            minHeap.offer(nums[i]);
        }
        return res;
    }
    
   
    
    public List<Integer> countSmaller(int[] nums) {
        return countSmallerMSort(nums);
        //return countSmallerHeapTLE(nums);
    }
}