class Solution {
    public int countTime(String time) {
        String[] arr = time.split(":");
        int hrs = 0;
        if(arr[0].charAt(0) == '?'){
            for(int i = 0; i <= 2; i++){
                if(arr[0].charAt(1) == '?'){
                    for (int j = 0; j <= 9; j++) {
                        if(Integer.parseInt(i + "" + j) <= 23){
                            hrs += 1;
                        }   
                    }
                }else if(Integer.parseInt(i + "" + arr[0].charAt(1)) <= 23){
                    hrs += 1;
                }
            }
        }else if(arr[0].charAt(1) == '?'){
            for (int j = 0; j <= 9 ; j++) {
                if(Integer.parseInt(arr[0].charAt(0) + "" + j) <= 23){
                    hrs += 1;
                }
            }
        }
        int mins = 0;
        if(arr[1].charAt(0) == '?'){
            for(int i = 0; i <= 5; i++){
                if(arr[1].charAt(1) == '?'){
                    for (int j = 0; j <= 9 ; j++) {
                        mins += 1;
                    }
                }else if(Integer.parseInt(i + "" + arr[1].charAt(1)) <= 59){
                    mins += 1;
                }
            }
        }else if(arr[1].charAt(1) == '?'){
            for (int j = 0; j <= 9 ; j++) {
                if(Integer.parseInt(arr[1].charAt(0) + "" + j) <= 59){
                    mins += 1;
                }
            }
        }
        if(hrs == 0 && mins == 0) return 1;
        if(hrs != 0 && mins != 0) {
            return hrs * mins;
        }
        return hrs == 0 ? mins : hrs;
    }
}