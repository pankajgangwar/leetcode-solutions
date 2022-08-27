class Solution {
    int n = 50001;
    int[] tree = new int[n + 1];
    public void add(int idx, int val){
        for (int i = idx + 1; i <= n ; i += lsb(i)) {
            tree[i] += val;
        }
    }
    public int lsb(int i){
        return i & -i;//return Integer.lowestOneBit(i);
    }
    public int prefixSum(int idx){
        int sum = 0;
        for (int i = idx + 1; i > 0; i -= lsb(i)) {
            sum += tree[i];
        }
        return sum;
    }

    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] line = new int[n + 1];
        for (int i = 0; i < shifts.length; i++) {
            line[shifts[i][0]] += (shifts[i][2] == 1) ? 1 : -1;
            line[shifts[i][1] + 1] += (shifts[i][2] == 1) ? -1 : +1;
            //add(shifts[i][0], (shifts[i][2] == 1) ? 1 : -1);
            //add(shifts[i][1] + 1, (shifts[i][2] == 1) ? -1 : 1);
        }
        char[] arr = s.toCharArray();
        for (int i = 0, count = 0; i < n; i++) {
            //arr[i] = (char) ('a' + (26 + (arr[i] - 'a') + prefixSum(i) % 26) % 26);
            count = (count + line[i]) % 26;
            arr[i] = (char)('a' + (26 + (arr[i] - 'a') + count) % 26);
        }
        return new String(arr);
    }
}

