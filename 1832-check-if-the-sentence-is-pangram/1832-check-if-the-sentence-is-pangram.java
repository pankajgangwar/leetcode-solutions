class Solution {
    public boolean checkIfPangram(String sentence) {
        for(char ch = 'a'; ch <= 'z'; ch++){
            boolean found = false;
            for(char ss : sentence.toCharArray()){
                if(ch == ss) {
                    found = true;
                    break;
                }
            }
            if(!found){
                return false;
            }
        }
        return true;
    }
}