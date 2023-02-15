class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {       
        HashSet<Integer> n1 = new HashSet<>();
        HashSet<Integer> n2 = new HashSet<>();
        for(int n : nums1){
            n1.add(n);
        }
        for(int n : nums2){
            n2.add(n);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        for(int a : n1){
            if(!n2.contains(a)){
                res.get(0).add(a);
            }
        }
        for(int a : n2){
            if(!n1.contains(a)){
                res.get(1).add(a);
            }
        }
        return res;
    }
}