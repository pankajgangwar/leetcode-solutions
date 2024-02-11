class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder out = new StringBuilder();
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if(isVowel(arr[i].charAt(0))){
                out.append(arr[i]).append("ma").append(String.join("", Collections.nCopies((i+1), "a")));
            }else{
                String a = arr[i];
                out.append(a.substring(1))
                        .append(a.charAt(0))
                        .append("ma").append(String.join("", Collections.nCopies((i+1), "a")));
            }
            out.append(" ");
        }
        return out.toString().trim();
    }
    
    public boolean isVowel(char ch){
        ch = Character.toLowerCase(ch);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}