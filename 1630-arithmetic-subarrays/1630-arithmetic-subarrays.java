class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> res = new ArrayList<>();
        int m = l.length;
        for (int i = 0; i < m; i++) {
            int start = l[i];
            int end = r[i];
            int[] temp = new int[end - start + 1];
            for(int x = 0, k = start; k <= end; k++, x++){
                temp[x] = nums[k];
            }
            System.out.println(Arrays.toString(temp));
            Arrays.sort(temp);
            boolean found = true;
            for (int j = 2; j < temp.length; j++) {
                if(temp[j] - temp[j - 1] != temp[1] - temp[0]){
                    found = false;
                    break;
                }
            }
            res.add(found);
        }
        return res;
    }
}