class Solution {

    class Trie {
        Trie[] children = new Trie[26];
        boolean isEnd = false;

        public void insert(Trie root, String s) {
            Trie curr = root;
            for (int i = 0; i < s.length(); i++) {
                int ch = s.charAt(i) - 'a';
                if (curr.children[ch] == null) {
                    curr.children[ch] = new Trie();
                }
                curr = curr.children[ch];
            }
            curr.isEnd = true;
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
            root.insert(root, new String(charArray));
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
