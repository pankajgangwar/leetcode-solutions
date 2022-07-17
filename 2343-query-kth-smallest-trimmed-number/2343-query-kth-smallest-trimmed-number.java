import java.math.BigInteger;
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int k = nums[0].length();
        int len = nums.length;
        HashMap<Integer, BigInteger[][]> map = new HashMap<>();
        for (int i = 1; i <= k ; i++) {
            map.putIfAbsent(i, new BigInteger[len][2]);
            for (int j = 0; j < len; j++) {
                String trim = nums[j].substring(k-i);
                BigInteger num = new BigInteger(trim);
                BigInteger[][] r = map.get(i);
                r[j] = new BigInteger[]{num, new BigInteger(j+"")};
                map.put(i, r);
            }
            BigInteger[][] arr = map.get(i);
            Arrays.sort(arr, new Comparator<BigInteger[]>() {
                @Override
                public int compare(BigInteger[] a, BigInteger[] b) {
                    int comp = a[0].compareTo(b[0]);
                    if(comp == 0){
                        return (a[1].subtract(b[1])).intValue();
                    }
                    return comp;
                }
            });
        }
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int kthSmallest = queries[i][0];
            int trimDigit = queries[i][1];
            BigInteger[][] r = map.get(trimDigit);
            res[i] = r[kthSmallest-1][1].intValue();
        }
        return res;
    }
}