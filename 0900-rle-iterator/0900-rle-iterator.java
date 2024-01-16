class RLEIterator {
        ArrayDeque<Integer> qNumber;
        ArrayDeque<Integer> qOccurance;
        int[] arr;
        public RLEIterator(int[] arr) {
            qNumber = new ArrayDeque<>();
            qOccurance = new ArrayDeque<>();
            this.arr = arr;
            /*for(int i = 0; i < arr.length - 1; i += 2) {
                int times = arr[i];
                int num = arr[i+1];

                qNumber.add(num);
                qOccurance.add(times);
            }*/
        }

        int start = 0;
        public int next(int n) {
            while(n > 0 && start < arr.length ) {
                int occ = arr[start];
                if(n > occ){
                    n = n - occ;
                    start += 2;
                }else{
                    occ = occ - n;
                    arr[start] = occ;
                    return arr[start+1];
                }
            }
            return -1;
            /*if(qOccurance.isEmpty()) return -1;

            while(n > 0 && !qNumber.isEmpty()) {
                int number = qNumber.pollFirst();
                int occ = qOccurance.pollFirst();

                if(n > occ){
                    n = n - occ;// n is bigger than occ, check next occ with remaining n
                }else{
                    occ = occ - n;//Add the remaining occ back to queue
                    qOccurance.addFirst(occ);
                    qNumber.addFirst(number);
                    return number;
                }
            }
            return -1;*/
        }
    }

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */