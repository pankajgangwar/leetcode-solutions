class Triplet {
    int index;
    String src, tar;
    public Triplet(int index, String src, String tar){
        this.index = index;
        this.src = src;
        this.tar = tar;
    }
}

class Solution {
    
      public String findReplaceString(String s, int[] indices, 
                                      String[] sources, String[] targets) {
        int n = indices.length;
        Triplet[] arr = new Triplet[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Triplet(indices[i], sources[i], targets[i]);
        }
        Arrays.sort(arr, (a,b) -> -a.index + b.index);
        HashSet<Integer> replaced = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int idx = arr[i].index;
            String src = arr[i].src;
            String sub = s.substring(idx);
            if (sub.startsWith(src) && !replaced.contains(idx)) {
                replaced.add(idx);
                String tar = arr[i].tar;
                String first = s.substring(0, idx);
                String last = s.substring(idx + src.length());
                s = first + tar + last;
            }
        }
        return s;
    }
}