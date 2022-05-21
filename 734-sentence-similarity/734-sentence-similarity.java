class Solution {

    public boolean areSentencesSimilar(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int n = sentence1.length;
        if (sentence2.length != n) return false;
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (List<String> list : similarPairs) {
            String a = list.get(0);
            String b = list.get(1);
            map.putIfAbsent(a, new HashSet<>());
            map.get(a).add(b);
        }
        for (int i = 0; i < n; i++) {
            String a = sentence1[i];
            String b = sentence2[i];
            if (!a.equals(b)) {
                HashSet<String> aa = map.getOrDefault(a, new HashSet<>());
                HashSet<String> bb = map.getOrDefault(b, new HashSet<>());
                if (aa.contains(b) || bb.contains(a)) continue;
                return false;
            }
        }
        return true;
    }
}
