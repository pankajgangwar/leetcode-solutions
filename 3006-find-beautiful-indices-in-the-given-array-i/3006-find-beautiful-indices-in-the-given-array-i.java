class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= s.length() - a.length(); i++) {
            if (s.substring(i, i + a.length()).equals(a)) {
                for (int j = Math.max(0, i - k); j <= Math.min(s.length() - b.length(), i + k); j++) {
                    if (s.substring(j, j + b.length()).equals(b)) {
                        result.add(i);
                        break;  // Move to the next i after finding a match for j
                    }
                }
            }
        }

        Collections.sort(result);
        return result;
    }
}