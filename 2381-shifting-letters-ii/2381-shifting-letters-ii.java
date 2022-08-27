class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] line = new int[n + 1];
        for (int i = 0; i < shifts.length; i++) {
            line[shifts[i][0]] += (shifts[i][2] == 1) ? 1 : -1;
            line[shifts[i][1] + 1] += (shifts[i][2] == 1) ? -1 : +1;
        }
        char[] arr = s.toCharArray();
        for (int i = 0, count = 0; i < n; i++) {
            count = (count + line[i]) % 26;
            arr[i] = (char) ('a' + (26 + (arr[i] - 'a') + count) % 26);
        }
        return new String(arr);
    }
}