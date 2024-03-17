class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         int m = intervals.length;

        ArrayList<int[]> intervalList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            intervalList.add(intervals[i]);
        }
        intervalList.add(newInterval);


        Collections.sort(intervalList, (o1, o2) -> o1[0] - o2[0]);

        for (int[] curr : intervalList) {
           // System.out.println(" intervals " + curr[0] + ","+ curr[1]);
        }

        //System.out.println("Total intervals " + intervalList.size());

        List<int[]> resultList = new ArrayList<>();

        int[] mergedInterval = intervalList.get(0);

        resultList.add(mergedInterval);

        for (int[] interval : intervalList) {
            if(interval[0] <= mergedInterval[1]){
                mergedInterval[1] = Math.max(mergedInterval[1], interval[1]);
            }else{
                mergedInterval = interval;
                resultList.add(mergedInterval);
            }
        }

        for (int i = 0; i < resultList.size(); i++) {
            //System.out.println("Merged intervals " + resultList.get(i)[0] + "," + resultList.get(i)[1]);
        }
        return resultList.toArray(new int[resultList.size()][2]);
    }
}