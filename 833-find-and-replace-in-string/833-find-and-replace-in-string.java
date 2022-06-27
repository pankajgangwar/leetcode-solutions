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
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        
        int n = indices.length;
        
        Triplet[] arr = new Triplet[n];
        for(int i = 0; i < n; i++){
            arr[i] = new Triplet(indices[i], sources[i], targets[i]);
        }
        
        Arrays.sort(arr, (a,b) -> a.index - b.index);
        
        int delta = 0;
        for (int i = 0; i < n; i++) {
            int idx = arr[i].index;
            String src = arr[i].src;
            String sub = s.substring(delta + idx);
            if (sub.startsWith(src)) {
                String tar = arr[i].tar;
                String first = s.substring(0, delta + idx);
                String last = s.substring(delta + idx + src.length());
                delta += tar.length() - src.length();
                s = first + tar + last;
            }
        }
        return s;
    }
}