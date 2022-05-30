class Solution {
    public boolean confusingNumber(int N) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(8, 8);
        map.put(9, 6);
        map.put(6, 9);
        map.put(1, 1);
        map.put(8, 8);
        map.put(0, 0);
        
        String number = String.valueOf(N);
        
        StringBuilder builder = new StringBuilder();
        
        
        for(int i = number.length()-1; i >= 0; --i) {
            int val = number.charAt(i) - '0';
            if(!map.containsKey(val)) return false;
            else builder.append(map.get(val));
        }
        //System.out.println(builder.toString());
        if(builder.toString().equals(number)) return false;
        
        return true;
    }
}