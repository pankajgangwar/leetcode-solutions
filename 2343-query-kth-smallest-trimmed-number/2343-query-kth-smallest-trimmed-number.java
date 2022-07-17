import java.math.BigInteger;
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
    HashSet<Integer> trims = new HashSet<>();
    for(int[] query : queries) trims.add(query[1]);  // set of all requires trim values to avoid extra work.
    
    HashMap<Integer, Node[]> x = new HashMap<>();  // set of arrays assosiated with each trim value.
    for(int trim : trims){
        Node[] arr = create(trim, nums);
        x.put(trim, arr);
    }
    
    int[] res = new int[queries.length];
    for(int i=0; i<queries.length; i++)
        res[i] = x.get(queries[i][1])[queries[i][0]-1].index; // get required value.
    return res;
}

Node[] create(int trim, String[] nums){  // returns a sorted array of trimmed values.
    Node[] arr = new Node[nums.length];
    int size = nums[0].length();
    for(int i=0; i<nums.length; i++){
        String x = nums[i].substring(size-trim, size); // trim to required length
        int start = 0;
        while(start!=x.length() && x.charAt(start)==0) start++; // handle leading zeroes
        x.substring(start, x.length());
        arr[i] = new Node(i, x);
    }
    Arrays.sort(arr, (a, b)-> a.val.length()>b.val.length()? 1 : // sort array according to their value
        b.val.length()>a.val.length() ?-1 :
        a.val.compareTo(b.val)
    );
    return arr;
}

class Node{
    int index; String val;  // custom object to store both index and value.
    Node(int i, String v){
        this.index = i; this.val = v;
    }
}
}