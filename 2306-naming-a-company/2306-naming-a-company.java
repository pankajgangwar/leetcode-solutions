class Solution {
    public long distinctNames(String[] ideas) {
        HashSet<String>[] sets = new HashSet[26];
        for (int i = 0; i < 26; i++) {
            sets[i] = new HashSet<String>();
        }
        for (int i = 0; i < ideas.length; i++) {
            char a = ideas[i].charAt(0);
            sets[a - 'a'].add(ideas[i].substring(1));
        }
        long res = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = i+1; j < 26; j++) {
                HashSet<String> a = sets[i];
                HashSet<String> b = sets[j];
                int duplicates = 0;
                for(String s : a){
                    if(b.contains(s)){
                        duplicates++;
                    }
                }
                res += (2 * (a.size() - duplicates) * (b.size() - duplicates));
            }
        }
        return res;
    }
}