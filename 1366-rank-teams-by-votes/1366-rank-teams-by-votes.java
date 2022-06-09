class Solution {
    public String rankTeams(String[] votes) {
        if (votes.length == 1) return votes[0];

        /*
           Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
           Output: "ACB"
        */
       HashMap<Character, int[]> map = new HashMap<>();
       int l = votes[0].length();

        for (int i = 0; i < votes.length; i++) {
            String curr = votes[i];
            for (int j = 0; j < curr.length(); j++) {
                char ch = curr.charAt(j);
                map.putIfAbsent(ch, new int[l]);
                map.get(ch)[j]++;
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a,b) -> {
            for (int i = 0; i < l; i++) {
                if(map.get(a)[i] != map.get(b)[i]){
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (char ch : list){
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}