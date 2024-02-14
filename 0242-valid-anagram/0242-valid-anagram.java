class Solution {
    public boolean isAnagram(String source, String dest) {
        int[] frequency = new int[26];
	        if(source.isEmpty() || dest.isEmpty())return true;
	        
	        int N = source.length();
	        int M = dest.length();
	        
	        if(N != M || N < M || N > M) return false;
	        
	        for(int i = 0; i < N; i++) {
	        	int index = source.charAt(i) - 'a';
	        	frequency[index]++;
	        }
	        
	        for(int i = 0; i < M; i++) {
	        	int index = dest.charAt(i) - 'a';
	        	if(frequency[index] > 0) {
	        		frequency[index]--;
	        	}else {
	        		return false;
	        	}
	        }
	        
	        return true;
    }
}