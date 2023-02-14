class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> sets = new HashSet<>();
        for(char ss : sentence.toCharArray()){
            sets.add(ss);
        }
        return sets.size() == 26;
    }
}