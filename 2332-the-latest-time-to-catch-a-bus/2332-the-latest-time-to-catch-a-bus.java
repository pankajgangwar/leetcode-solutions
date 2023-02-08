class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int i = 0, j = 0, start = 0;
        while (i < buses.length - 1 && j < passengers.length) {
            if(passengers[j] <= buses[i] && j - start < capacity){
                ++j;
            }else {
                ++i;
                start = j;
            }
        }
        while (j < passengers.length && passengers[j] <= buses[i] && capacity > 0){
            ++j;
            --capacity;
        }
        int latest = capacity > 0 ? buses[buses.length -1] : passengers[j-1];
        for(j = j - 1; j >= 0 && latest == passengers[j]; --j){
            latest = passengers[j] - 1;
        }
        return latest; 
    }
}