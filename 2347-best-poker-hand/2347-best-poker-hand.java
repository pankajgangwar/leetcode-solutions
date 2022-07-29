class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        String flush = "Flush";
        String threeOfKind = "Three of a Kind";
        String pair = "Pair";
        String single = "High Card";
        int[] rank = new int[14];
        for(int r : ranks){
            rank[r]++;
        }
        int[] s = new int[4];
        for(char suit : suits){
            s[suit - 'a']++;
        }
        for(int suit : s){
            if(suit == 5) return flush;
        }
        rank = Arrays.stream(rank).boxed().sorted((a,b) -> b - a).mapToInt(i -> i).toArray();
        for(int r : rank){
            if(r >= 3) return threeOfKind;
            if(r == 2) return pair;
        }
        return single;
    }
}