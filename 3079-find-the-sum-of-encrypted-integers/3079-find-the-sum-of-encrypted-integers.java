class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        long ans = 0;
        for(int a : nums){
            String s = String.valueOf(a);
            int max = 0;
            for(char ch : s.toCharArray()){
                max = Math.max(max, (int)ch - '0');
            }
            StringBuilder out = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                out.append(max);
            }

            ans += (Long.parseLong(out.toString()));
        }
        return (int)ans;
    }
}