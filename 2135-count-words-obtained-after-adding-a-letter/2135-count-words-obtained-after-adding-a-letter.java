class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<String> dictS = new HashSet<>();
        for(String s : startWords) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            dictS.add(new String(arr));
        }
        int res = 0;
        for(String s : targetWords) {
            for(int i = 0; i < s.length(); i++){
                StringBuilder a = new StringBuilder(s);
                a.deleteCharAt(i);
                char[] arr = (a.toString()).toCharArray();
                Arrays.sort(arr);
                String ss = new String(arr);
                if(dictS.contains(ss)){
                    res += 1;
                    break;
                }
            }
        }
        return res;
    }
}