class Solution {
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] peak = new int[n];
        for(int i = 0; i < n; i++){
            if(i-1 >=0 && nums[i] > nums[i-1]
                    && i+1 < n && nums[i] > nums[i+1]){
                peak[i] = 1;
            }
        }
        SegmentTree tree = new SegmentTree(peak);
        List<Integer> res = new ArrayList<>();
        for(int[] q : queries){
            if(q[0] == 1){ //query
                int l = q[1], r = q[2];
                if(l == r){
                    res.add(0);
                }else{
                    int remove = peak[l] + peak[r];
                    int ans = tree.query(l, r);
                    //System.out.println("ans " + ans + " peak" + Arrays.toString(peak));
                    res.add((ans - remove));
                }
            }else{ // update
                int idx = q[1];
                nums[idx] = q[2];
                if(idx-1 >= 0 && idx+1 < n){
                    int newVal = nums[idx] > nums[idx-1] && nums[idx] > nums[idx+1] ? 1 : 0;
                    peak[idx] = newVal;
                    tree.update(idx, newVal);
                }
                if(idx-2>=0 && idx < n){
                    int newVal = nums[idx-1] > nums[idx-2] && nums[idx-1] > nums[idx] ? 1 : 0;
                    peak[idx-1] = newVal;
                    tree.update(idx-1, newVal);
                }
                if(idx >= 0 && idx+2<n){
                    int newVal = nums[idx+1] > nums[idx] && nums[idx+1] > nums[idx+2] ? 1 : 0;
                    peak[idx+1] = newVal;
                    tree.update(idx+1, newVal);
                }
            }
        }
        return res;
    }
    
    public static class SegmentTree {

        private int[] st;
        private int[] arr;
        int n;

        public SegmentTree(int[] arr) {
            n =  arr.length;
            this.arr = arr;
            int height = (int) Math.ceil(Math.log(n) / Math.log(2));
            int size = 2 * (int) Math.pow(2, height) - 1;
            st = new int[size];
            build(arr, 0, n - 1, 0);
        }

        private void build(int[] arr, int ss, int se, int si) {
            if (ss == se) {
                st[si] = arr[ss];
                return;
            }

            //int mid = ss + (se - ss) / 2;
            int mid = (ss + se) >> 1;
            build(arr, ss, mid, si * 2 + 1);
            build(arr, mid + 1, se, si * 2 + 2);

            st[si] = st[2 * si + 1] + st[2 * si + 2];
        }

        public int query(int qs, int qe) {
            return query(qs, qe, 0, 0, n - 1);
        }

        private int query(int qs, int qe, int si, int ss, int se) {
            if (qs > se || qe < ss) {
                return 0;
            }

            if (qs <= ss && qe >= se) {
                return st[si];
            }

            int mid = ss + (se - ss) / 2;
            int left = query(qs, qe, 2 * si + 1, ss, mid);
            int right = query(qs, qe, 2 * si + 2, mid + 1, se);

            return left + right;
        }

        public void update(int index, int value) {
            if(index < 0 || index >= n) {
                throw new IllegalArgumentException("Invalid index");
            }
            arr[index] = value;
            update(index, value, 0, 0, n - 1);
        }

        private void update(int index, int value, int si, int ss, int se) {
            if (index < ss || index > se) {
                return;
            }

            if (ss == se) {
                st[si] = value;
                return;
            }

            int mid = ss + (se - ss) / 2;
            if(index <= mid){
                update(index, value, 2 * si + 1, ss, mid);
            }else{
                update(index, value, 2 * si + 2, mid + 1, se);
            }
            st[si] = st[2 * si + 1] + st[2 * si + 2];
        }
    }
}