class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int tank = 0, start = 0;
        for(int i = 0; i < gas.length; i++){
            totalGas += gas[i];
            totalCost += cost[i];
            
            tank += gas[i] - cost[i];
            if(tank < 0){
                start = i + 1;
                tank = 0;
            }
        }
        if(totalCost > totalGas){
            return -1;
        }else{
            return start;
        }
        
        /*for(int i = 0; i < gas.length; i++){
            if(isValidIndex(i, gas, cost)){
                return i;
            }
        }
        return -1;*/
    }
    
    public boolean isValidIndex(int start, int[] gas, int[] cost){
        int tank = gas[start] - cost[start];
        int n = gas.length;
        int i  = start + 1;
        while(i != start){
           if(tank < 0) return false;
           tank += gas[i%n] - cost[i%n];
           i++;
           i = i % n;
        }
         return tank >= 0;
    }
}