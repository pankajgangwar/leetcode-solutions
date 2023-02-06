class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        PriorityQueue<Integer> aOdd = new PriorityQueue<>();
        PriorityQueue<Integer> aEven = new PriorityQueue<>();
        for(int a : nums){
            if(a%2==0)aEven.add(a);
            else aOdd.add(a);
        }

        PriorityQueue<Integer> bOdd = new PriorityQueue<>();
        PriorityQueue<Integer> bEven = new PriorityQueue<>();
        for(int a : target){
            if(a%2==0)bEven.add(a);
            else bOdd.add(a);
        }
        long res = 0;
        while (!aOdd.isEmpty() && !bOdd.isEmpty()){
            int x = aOdd.poll(); int y = bOdd.poll();
            res += Math.abs(x - y) / 2;
        }

        while (!aEven.isEmpty() && !bEven.isEmpty()){
            int x = aEven.poll(); int y = bEven.poll();
            res += Math.abs(x - y) / 2;
        }
        return res / 2;
    }
}