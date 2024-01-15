class Solution {
    
public boolean canMeasureWater1(int jug1, int jug2, int target) {
    if(jug1+jug2<target) return false;
    if(jug1%2==0&&jug2%2==0&&target%2!=0) return false;
    
    Queue<int[]> q = new LinkedList<>();
    q.add(new int[]{0,0});
    HashSet visited = new HashSet<>();
    while(!q.isEmpty()){
        int[] curr = q.poll();
        int x = curr[0], y = curr[1];
        if(visited.contains(x+","+y)) continue;
        if(x+y==target) return true;
        visited.add(x+","+y);
        q.add(new int[]{0, y});
        q.add(new int[]{x, 0});
        q.add(new int[]{jug1, y});
        q.add(new int[]{x, jug2});
        q.add(new int[]{x-Math.min(x, jug2-y), y+Math.min(x, jug2-y)});
        q.add(new int[]{x+Math.min(y, jug1-x), y-Math.min(y, jug1-x)});
    }
    return false;
}
    public boolean canMeasureWater(int x, int y, int z) {
        if(x + y < z) return false;
        if(x == z || y == z || x + y == z) return true;
        return z % gcd(x, y) == 0;
    }

    public int gcd(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println("a " + a);
        return a;
    }
}