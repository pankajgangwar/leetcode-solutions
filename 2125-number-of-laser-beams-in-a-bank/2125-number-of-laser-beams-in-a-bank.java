class Solution {
    public int numberOfBeams(String[] bank) {
        int prevRowCameras = -1;
        int res = 0;
        for (int i = 0; i < bank.length; i++) {
            int camera = 0;
            for(char ch : bank[i].toCharArray()){
                if(ch == '1'){
                    camera += 1;
                }
            }
            if(prevRowCameras > 0){
                res += (prevRowCameras * camera);
            }
            if(camera > 0){
                prevRowCameras = camera;
            }
        }
        return res;
    }
}