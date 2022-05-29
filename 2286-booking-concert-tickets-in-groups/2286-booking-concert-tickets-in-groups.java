
class SegmentTree {

     public int nextPowerOf2(int num){
        if(num ==0){
            return 1;
        }
        if(num > 0 && (num & (num-1)) == 0){
            return num;
        }
        while((num & (num-1)) > 0){
            num = num & (num-1);
        }
        return num<<1;
    }
    
        int[] segTree;
        public SegmentTree(int n){
            int x = (int)Math.ceil(Math.log(n)/ Math.log(2)); // Height of tree
            int max_size = 2 *(int)Math.pow(2, x) -1;
            //segTree = new int[max_size];
            segTree = new int[4 * n + 5];
           // int nextPowerOfTwo = nextPowerOf2(n);
            //segTree = new int[nextPowerOfTwo * 2 - 1];
            //Arrays.fill(segTree, Integer.MIN_VALUE);
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

        public int rangeMinQuery(int qLow, int qHigh, int low, int high, int pos){
            if(qLow <= low && qHigh >= high){//total overlap
                return segTree[pos];
            }
            if(qLow > high || qHigh < low) { //No overlap
                return Integer.MAX_VALUE;
            }
            int mid = (low + high) / 2;
            int q1 = rangeMinQuery(qLow, qHigh, low, mid, 2*pos);
            int q2 = rangeMinQuery(qLow, qHigh, mid + 1, high, 2*pos + 1);
            return Math.min(q1, q2);
        }
    }

class BookMyShow {

        SegmentTreeRMQ st;
        int m;
        long[] ft;

        public BookMyShow(int n, int m) {
            this.m = m;
            int[] a = new int[n];
            st = new SegmentTreeRMQ(a);
            ft = new long[n+5];
            for(int i = 0;i < n;i++){
                addFenwick(ft, i, m);
            }
        }

        public int[] gather(int k, int maxRow) {
            int f = st.firstle(0, m-k);
            if(f == -1 || f > maxRow)return new int[0];
            int v = st.min(f, f+1);
            st.update(f, v + k);
            addFenwick(ft, f, -k);
            return new int[]{f, v};
        }

        public boolean scatter(int k, int maxRow) {
            if(sumFenwick(ft, maxRow) < k)return false;
            while(k > 0){
                int f = st.firstle(0, m-1);
                if(f == -1 || f > maxRow)break;
                int v = st.min(f, f+1);
                int use = Math.min(k, m-v);
                k -= use;
                st.update(f, v + use);
                addFenwick(ft, f, -use);
            }
            return true;
        }

        public static long sumFenwick(long[] ft, int i)
        {
            long sum = 0;
            for(i++;i > 0;i -= i&-i)sum += ft[i];
            return sum;
        }

        public static void addFenwick(long[] ft, int i, long v)
        {
            if(v == 0)return;
            int n = ft.length;
            for(i++;i < n;i += i&-i)ft[i] += v;
        }
    }

    public class SegmentTreeRMQ {
        public final int M, H, N;
        public int[] vals;
        public static final int I = Integer.MAX_VALUE;

        public SegmentTreeRMQ(int n)
        {
            N = n;
            M = Integer.highestOneBit(Math.max(N-1, 1))<<2;
            H = M>>>1;
            vals = new int[M];
            Arrays.fill(vals, 0, M, I);
        }

        public SegmentTreeRMQ(int[] a)
        {
            this(a.length);
            for(int i = 0;i < N;i++){
                vals[H+i] = a[i];
            }
            //		Arrays.fill(vals, H+N, M, I);
            for(int i = H-1;i >= 1;i--)propagate(i);
        }

        public void update(int pos, int x)
        {
            vals[H+pos] = x;
            for(int i = (H+pos)>>>1;i >= 1;i >>>= 1)propagate(i);
        }

        private void propagate(int i)
        {
            vals[i] = Math.min(vals[2*i], vals[2*i+1]);
        }

        public int min(int l, int r){
            int min = I;
            if(l >= r)return min;
            l += H; r += H;
            for(;l < r;l>>>=1,r>>>=1){
                if((l&1) == 1)min = Math.min(min, vals[l++]);
                if((r&1) == 1)min = Math.min(min, vals[--r]);
            }
            return min;
        }

        public int firstle(int l, int v) {
            if(l >= H)return -1;
            int cur = H+l;
            while(true){
                if(vals[cur] <= v){
                    if(cur >= H)return cur-H;
                    cur = 2*cur;
                }else{
                    cur++;
                    if((cur&cur-1) == 0)return -1;
                    if((cur&1)==0)cur>>>=1;
                }
            }
        }

        public int lastle(int l, int v) {
            if(l < 0)return -1;
            int cur = H+l;
            while(true){
                if(vals[cur] <= v){
                    if(cur >= H)return cur-H;
                    cur = 2*cur + 1;
                }else{
                    if((cur&cur-1) == 0)return -1;
                    cur--;
                    if((cur&1)==1)cur>>>=1;
                }
            }
        }
    }


/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow obj = new BookMyShow(n, m);
 * int[] param_1 = obj.gather(k,maxRow);
 * boolean param_2 = obj.scatter(k,maxRow);
 */