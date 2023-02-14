class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> sets = new HashSet<>();
        for(char ch = 'a'; ch <= 'z'; ch++){
            sets.add(ch);
        }
        for(char ss : sentence.toCharArray()){
            sets.remove(ss);
        }
        return sets.isEmpty();
    }
}