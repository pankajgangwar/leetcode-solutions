class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        for(int n : nums){
            freq[n]++;
        }
        int maxFreq = Arrays.stream(freq).max().getAsInt();
        int count = 0;
        for(int f : freq){
            if(f == maxFreq){
                count += f;
            }
        }
        return count;
    }
}