class Solution {
    public String smallestBeautifulString(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i = arr.length - 1; i >=0 ; i--) {
            arr[i]++;
            //System.out.println(Arrays.toString(arr));
            while (!isValid(arr, i)){
                arr[i]++;
            }
            if(arr[i] < 'a' + k){
                for(i = i + 1; i < s.length(); i++){
                    for(arr[i] = 'a'; !isValid(arr, i); arr[i]++);
                }
                return new String(arr);
            }
        }
        return "";
    }

    public boolean isValid(char[] arr, int i){
        return (i < 1 || arr[i] != arr[i-1]) && (i < 2 || arr[i] != arr[i-2]);
    }
}