class Solution {
    public int subarraysDivByK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);
        
        for(int i = 0, j = 0; i < arr.length; i++ ){
            //sum = (sum + arr[i] % k + k) % k;
            sum = (sum + arr[i] % k + k) % k;
            count += map.getOrDefault(sum, 0);
            map.put(sum, map.getOrDefault(sum , 0) +1);
        }
        return count;
    }
}