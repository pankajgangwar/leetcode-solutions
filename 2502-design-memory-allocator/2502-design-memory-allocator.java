class Allocator {
        int[] arr = new int[1001];
        int n;
        public Allocator(int n) {
            this.n = n;
        }

        public int allocate(int size, int mID) {
            int start = -1;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    start = i;
                    while (i < n && arr[i] == 0) i++;

                    if(i - start >= size) {
                        break;
                    } else{
                        start = -1;
                    }
                    i--;
                }
            }
            if (start == -1)
                return -1;
            for (int i = start; i < start + size; i++)
                arr[i] = mID;

            return start;
        }

        public int free(int mID) {
            int count=0,start=0;
            while (start < n) {
                if (arr[start] == mID) {
                    count++;
                    arr[start] = 0;
                }
                start++;
            }
            return count;
        }
    }

/**
 * Your Allocator object will be instantiated and called as such:
 * Allocator obj = new Allocator(n);
 * int param_1 = obj.allocate(size,mID);
 * int param_2 = obj.free(mID);
 */