class Solution {
     public int countVowelStrings(int n) {
        return dfs(n, new ArrayList<Character>());
    }

    public int dfs(int n, ArrayList<Character> list){
        if(list.size() == n) return 1;
        char[] arr = new char[]{'a', 'e', 'i', 'o', 'u'};
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(!list.isEmpty() && list.get(list.size()-1) > arr[i])continue;
            list.add(arr[i]);
            count += dfs(n, list);
            list.remove(list.size()- 1);
        }
        return count;
    }

}