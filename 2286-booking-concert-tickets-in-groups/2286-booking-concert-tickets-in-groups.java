 class BIT {
        int size;
        long[] tree;

        public BIT(int n) {
            this.size = n + 2;
            tree = new long[size];
        }

        public void update(int i, int new_val) {
            long prev_val = sumRange(i, i);
            add(i, new_val - prev_val);
        }

        public void add(int i, long val){
            i += 1;
            while (i < size){
                tree[i] += val;
                i = i + lsb(i);
            }
        }

        long query(int i) {
            i += 1;
            long sum = 0;
            while (i > 0) {
                sum += tree[i];
                i = i - lsb(i);
            }
            return sum;
        }

        public long sumRange(int i, int j) {
            if(j < i) throw new IllegalArgumentException(" Make sure j >= i");
            return query(j) - query(i - 1);
        }

        public int lsb(int i){
            return Integer.lowestOneBit(i);
        }

    }

    class SegmentTree {
        long[] segTree;
        public SegmentTree(int n){
            segTree = new long[4*n+5];
        }
        public void update(int value, int low, int high, int idx, int pos){
            if(low == high && idx == low){
                segTree[pos] += value;
                return;
            }
            int mid = (low + high)/2;
            if(idx >= low && idx <= mid) update(value, low, mid, idx, 2*pos);
            if(idx >= (mid+1) && idx <= high) update(value, mid + 1, high, idx, 2*pos + 1);
            segTree[pos] = Math.min(segTree[2*pos], segTree[2*pos + 1]);
        }
        public long rangeMinQuery(int qLow, int qHigh, int low, int high, int pos){
            if(low >= qLow && high <= qHigh) return segTree[pos];
            if(high < qLow || low > qHigh) return Long.MAX_VALUE;
            int mid = (low + high) / 2;
            long q1 = rangeMinQuery(qLow, qHigh, low, mid, 2*pos);
            long q2 = rangeMinQuery(qLow, qHigh, mid + 1, high, 2*pos + 1);
            return Math.min(q1, q2);
        }
    }

    class BookMyShow {
        int _n = 0;
        int _m = 0;
        SegmentTree segTree;
        BIT bit;
        int[] cnt ;
        int idx = 0;
        public BookMyShow(int n, int m) {
            _n = n;
            _m = m;
            segTree = new SegmentTree(n);
            bit = new BIT(n);
            cnt = new int[n];
        }

        public int[] gather(int k, int maxRow) {
            int low = 0, high = maxRow;
            int index = -1;
            int booked = 0;
            while (low <= high){
                int mid = (low + high) / 2;
                int currCnt = (int)segTree.rangeMinQuery(1, mid + 1, 1, _n, 1);
                if(_m - currCnt >= k){
                    index = mid;
                    booked = currCnt;
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            if(index == -1) return new int[]{};
            segTree.update(k, 1, _n, index + 1, 1);
            bit.add(index + 1, k);
            cnt[index] += k;
            return new int[]{index, booked};
        }

        public boolean scatter(int k, int maxRow) {
            long rem = (long)_m * (maxRow+1) - bit.query(maxRow+1);
            if(rem < k) return false;
            while (idx <= maxRow && k > 0){
                if(cnt[idx] == _m){
                    idx++;
                    continue;
                }
                int mn = Math.min(k, _m - cnt[idx]);
                cnt[idx] += mn;
                k -= mn;
                segTree.update(mn, 1, _n, idx + 1, 1);
                bit.add(idx + 1, mn);
                if(k <= 0) break;
                idx++;
            }
            return true;
        }
    }
