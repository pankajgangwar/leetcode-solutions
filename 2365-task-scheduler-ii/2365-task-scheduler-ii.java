class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long days = 0;
        HashMap<Integer, Long> map = new HashMap<>();
        int n = tasks.length;
        for (int i = 0; i < n; i++) {
            int type = tasks[i];
            if(map.containsKey(type)){
                days = Math.max(days, map.get(type));
            }
            days += 1;
            map.put(type, days + space);
        }
        return days;
    }
}