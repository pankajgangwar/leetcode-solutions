class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] arr = new boolean[n];
        int i = 0;
        int step = 1;
        while (!arr[i]){
            arr[i] = true;
            int next = step*k;
            step++;
            i = (i + next) % (n);
        }
        List<Integer> pos = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if(!arr[j]) pos.add(j+1);
        }
        return pos.stream().mapToInt(e -> e).toArray();
    }
}