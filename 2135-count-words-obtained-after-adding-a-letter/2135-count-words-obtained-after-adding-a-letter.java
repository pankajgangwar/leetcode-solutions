class Solution {

    class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd = false;

        public void insert(String s, int idx) {
            if(idx == s.length()){
                isEnd = true;
                return;
            }
            int ch = s.charAt(idx) - 'a';
            if(children[ch] == null){
                children[ch] = new Trie();
            }
            children[ch].insert(s, idx + 1);
        }


        public boolean find(String s, int index, boolean skipped) {
            if(index == s.length()) return (skipped && isEnd);
            int ch = s.charAt(index) - 'a';
            boolean res = children[ch] != null && children[ch].find(s, index + 1, skipped);
             res = res || (find(s, index + 1, true) && !skipped);
            return res;
        }
    }

    public int wordCount(String[] s, String[] t) {
        Trie root = new Trie();
        for (int i = 0; i < s.length; i++) {
            String ss = s[i];
            char[] charArray = ss.toCharArray();
            Arrays.sort(charArray);
            root.insert(new String(charArray), 0);
        }

        int res = 0;
        for (int i = 0; i < t.length; i++) {
            String ss = t[i];
            char[] charArray = ss.toCharArray();
            Arrays.sort(charArray);
            if (root.find(new String(charArray), 0, false)) {
                res += 1;
            }
        }
        return res;
    }

    public int wordCountHashSet(String[] startWords, String[] targetWords) {
        HashSet<String> dictS = new HashSet<>();
        for (String s : startWords) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            dictS.add(new String(arr));
        }
        int res = 0;
        for (String s : targetWords) {
            StringBuilder a = new StringBuilder(s);
            for (int i = 0; i < s.length(); i++) {
                a.deleteCharAt(i);
                char[] arr = (a.toString()).toCharArray();
                Arrays.sort(arr);
                String ss = new String(arr);
                if (dictS.contains(ss)) {
                    res += 1;
                    break;
                }
                a.insert(i, s.charAt(i));
            }
        }
        return res;
    }
}
