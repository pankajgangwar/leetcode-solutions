class Solution {
    public int similarPairs(String[] words) {
        int pairs = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String a = words[i];
                String b = words[j];
                HashSet<Character> setA = new HashSet<>();
                for(char ch : a.toCharArray()){
                    setA.add(ch);
                }
                HashSet<Character> setB = new HashSet<>();
                for(char ch : b.toCharArray()){
                    setB.add(ch);
                }
                //if(setA.size() != setB.size()) break;
                boolean flag = false;
                for(char ch : setA){
                    if(!setB.contains(ch)) {
                        flag = true;
                        break;
                    }
                }
                for(char ch : setB){
                    if(!setA.contains(ch)) {
                        flag = true;
                        break;
                    }
                }
                if(!flag) pairs += 1;
            }
        }
        return pairs;
    }
}