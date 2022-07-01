class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) -> - a[1] + b[1]);
        
        int maxUnits = 0;
        for(int i = 0; i < boxTypes.length; i++){
            int[] type = boxTypes[i];
            int boxes = type[0];
            int unit = type[1];
            
            if(boxes <= truckSize){
                truckSize -= boxes;
                maxUnits += (unit * boxes);
            }else{
                maxUnits += (unit * truckSize);
                return maxUnits;
            }
        }
        return maxUnits;
    }
}