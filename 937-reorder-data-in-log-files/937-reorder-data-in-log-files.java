class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                String[] arr1 = str1.split(" ", 2);
                String[] arr2 = str2.split(" ", 2);

                boolean isDigit1 = Character.isDigit(arr1[1].charAt(0));
                boolean isDigit2 = Character.isDigit(arr2[1].charAt(0));
                if(!isDigit1 && !isDigit2){
                    int comp = arr1[1].compareTo(arr2[1]);
                    if(comp == 0) return arr1[0].compareTo(arr2[0]);
                    else return comp;
                }else if(isDigit1 && isDigit2){
                    return 0;
                }else if(isDigit1 && !isDigit2){
                    return 1;
                }else{
                    return -1;
                }
            }
        };

        Arrays.sort(logs, comparator);
        return logs;
    }
}