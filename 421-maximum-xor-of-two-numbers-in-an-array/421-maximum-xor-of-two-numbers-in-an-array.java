class Solution {
    
    public int findMaximumXOR(int[] nums) {
        return findMaximumXORUsingTrie(nums);
        //return findMaximumXORUsingSets(nums);
    }
    
    class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
        public TrieNode() { }
    }

    public int findMaximumXORUsingTrie(int[] nums){
        int max = nums[0];
        for(int n : nums) max = Math.max(max, n);

        int l = Integer.toBinaryString(max).length();
        int len = nums.length, bitMask = 1 << l;

        String[] strNums = new String[len];

        for(int i = 0; i < len; ++i){
            strNums[i] = Integer.toBinaryString(bitMask | nums[i]).substring(1);
        }

        int max_xor = 0;
        TrieNode root = new TrieNode();
        for(String n : strNums) {
            TrieNode curr = root, xorNode = root;
            int curr_xor = 0;
            for(Character bit : n.toCharArray()) {
                if(curr.children.containsKey(bit)) {
                    curr = curr.children.get(bit);
                }else{
                    TrieNode node = new TrieNode();
                    curr.children.put(bit, node);
                    curr = node;
                }

                Character bitFlip = bit == '0' ? '1' : '0';

                if(xorNode.children.containsKey(bitFlip)) {
                    curr_xor = (curr_xor << 1) | 1;
                    xorNode = xorNode.children.get(bitFlip);
                }else {
                    curr_xor = curr_xor << 1;
                    xorNode = xorNode.children.get(bit);
                }
                max_xor = Math.max(max_xor, curr_xor);
            }
        }
        return max_xor;
    }
    
    public int findMaximumXORUsingSets(int[] nums) {
        int max_xor = 0, curr_xor = 0;
        HashSet<Integer> prefixes = new HashSet<>();
        int max = 0;
        for(int n : nums) max = Math.max(max, n);

        int l = Integer.toBinaryString(max).length();
    
        for(int i = l - 1; i >=0 ; --i){
            max_xor = max_xor << 1; // make space of right most bit

            curr_xor = max_xor | 1; // add 1 to right most bit

            prefixes.clear();
            for(int n : nums){
                prefixes.add(n >> i); // add ith bit to prefixes
            }

            for(int n : prefixes) {
                // p1^p2 = curr
                // curr ^ p2 = p1
                if(prefixes.contains(curr_xor ^ n)){ 
                    max_xor = curr_xor;
                    break;
                }
            }
        }
        return max_xor;
    }
}