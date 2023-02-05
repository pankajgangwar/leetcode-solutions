class Solution {
    int inf = (int) 1e9 + 5;
    public long minCost(int[] b1, int[] b2) {
        int n = b1.length, m = b2.length, mn = inf;
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> b1Freq = new HashMap<>();
        for (int x : b1) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            b1Freq.put(x, b1Freq.getOrDefault(x, 0) + 1);
        }
        HashMap<Integer, Integer> b2Freq = new HashMap<>();
        for (int x : b2) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            b2Freq.put(x, b2Freq.getOrDefault(x, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            mn = Math.min(mn, e.getKey());
            if ((e.getValue() % 2) != 0) return -1;
        }
        ArrayList<Integer> b1List = new ArrayList<>();
        ArrayList<Integer> b2List = new ArrayList<>();
        for (Map.Entry<Integer, Integer> e : b1Freq.entrySet()) {
            while (e.getValue() > freq.get(e.getKey()) / 2) {
                b1List.add(e.getKey());
                e.setValue(e.getValue() - 1);
            }
        }
        for (Map.Entry<Integer, Integer> e : b2Freq.entrySet()) {
            while (e.getValue() > freq.get(e.getKey()) / 2) {
                b2List.add(e.getKey());
                e.setValue(e.getValue() - 1);
            }
        }
        Collections.sort(b1List);
        Collections.sort(b2List, Collections.reverseOrder());
        long res = 0;
        for (int i = 0; i < b1List.size(); i++) {
            res = res + Math.min(Math.min(b1List.get(i), b2List.get(i)), mn * 2);
        }
        return res;
    }
}