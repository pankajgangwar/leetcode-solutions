class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        LinkedList<int[]> queue = new LinkedList<>();
        int max = -1;
        for (int i = 0; i < skills.length; i++) {
            queue.add(new int[]{skills[i], i, k});
            max = Math.max(max, skills[i]);
        }
        int prevWinner = skills[0] > skills[1] ? 0 : 1;
        while (queue.size() >= 2){
            int[] a = queue.pollFirst();
            int[] b = queue.pollFirst();
            if(a[0] == max) return a[1];
            if(b[0] == max) return b[1];
            if(a[0] > b[0]){
                if(queue.isEmpty()){
                   return a[1];
                }
                if(prevWinner == a[1]){
                    if(a[2] - 1 == 0) {
                        return a[1];
                    }else{
                        a[2] -= 1;
                    }
                }else{
                    a[2] = k - 1;
                }
                prevWinner = a[1];
                queue.addFirst(a);
                queue.addLast(b);
            }else{
                if(queue.isEmpty()){
                    return b[1];
                }
                if(prevWinner == b[1]){
                    if(b[2] - 1 == 0) {
                        return b[1];
                    }else{
                        b[2] -= 1;
                    }
                }else{
                    b[2] = k - 1;
                }
                prevWinner = b[1];
                queue.addFirst(b);
                queue.addLast(a);
            }
        }
        return -1;
    }
}