class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0, j = 0; i < encoded1.length && j < encoded2.length; ) {
            int[] a = encoded1[i];
            int[] b = encoded2[j];
            int prod = a[0] * b[0];
            int prevProd = res.isEmpty() ? 0 : res.get(res.size()-1).get(0);
            int prevOcc = res.isEmpty() ? 0 : res.get(res.size()-1).get(1);
            int reduce = Math.min(a[1], b[1]);
            if(prod == prevProd){
                prevOcc += reduce;
                res.get(res.size()-1).set(1, prevOcc);
            }else{
                List<Integer> ss = new ArrayList<>();
                ss.add(prod);
                ss.add(reduce);
                res.add(ss);
            }
            if(a[1] < b[1]){
                b[1] -= reduce;
                i++;
            }else if(a[1] > b[1]){
                a[1] -= reduce;
                j++;
            }else{
                i++;
                j++;
                a[1] -= reduce;
                b[1] -= reduce;
            }
        }
        return res;
    }
}