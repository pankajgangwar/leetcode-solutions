class Solution {
    public int minimizeSum(int[] a) {
        int n = a.length;
        Arrays.sort(a);
        //Change 2 biggest -> a[n-3] - n[0]
        //Change smallest and biggest -> a[n-2] - a[1]  
        //Change 2 smallest -> a[n-1] - a[2]
        return Math.min(a[n-3] - a[0], Math.min(a[n-2] - a[1], a[n-1] - a[2]));
    }
}