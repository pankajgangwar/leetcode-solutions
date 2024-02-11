class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {List<Integer> ans = new ArrayList<>();
        for(int a : arr1){
            if(Arrays.binarySearch(arr2, a) >= 0 && Arrays.binarySearch(arr3, a) >= 0){
                ans.add(a);
            }
        }
        return ans;
    }
}