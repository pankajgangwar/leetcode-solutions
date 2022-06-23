class Solution {
    /*
    Sa -A + B = Sb - B + A
    2(A-B) = (Sa-Sb)
    A-B = (Sa-Sb)/2
    A = B+(Sa-Sb)/2
    */
    public int[] fairCandySwap(int[] a, int[] b) {
        int aSum = Arrays.stream(a).sum();
        int bSum = Arrays.stream(b).sum();
        int diff = (aSum - bSum) / 2;

        //Arrays.sort(a);
        HashSet<Integer> aSet = new HashSet<>();
        for(int x : a) aSet.add(x);
        for (int num : b) {
            /*int B = Arrays.binarySearch(a, num + diff);
            if(B >= 0){
                return new int[]{num + diff, num};
            }*/
            if(aSet.contains(num + diff)){
                return new int[]{num + diff, num};
            }
        }
        return new int[]{};
    }
}