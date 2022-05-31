class Solution {
    public List<Long> maximumEvenSplit(long sum) {
        List<Long> ans = new ArrayList<>();
        if(sum % 2 != 0) return ans;

        long curr = 2l;
        HashSet<Long> temp = new HashSet<>();
        while (sum > 0){
            long diff = sum - curr;
            if (diff != curr && !temp.contains(diff)) {
                temp.add(curr);
                sum -= curr;
            }
            curr += 2;
        }
        return new ArrayList<>(temp);
    }
}