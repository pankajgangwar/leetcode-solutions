class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();

        int i = 0;
        int j = 0;
        while(i < n1 && j < n2){
            char a = str1.charAt(i);
            char b = str2.charAt(j);
            
            int idx = a - 'a';
            idx += 1;
            idx %= 26;
            
            char res = (char)('a' + idx);
            //System.out.println(a + " -> " + res );
            
            if(a == b){
                i++;
                j++;
            }else if(res == b){
                i++;
                j++;
            }else{
                i++;
            }
        }
        
        return j == n2;
    }
}