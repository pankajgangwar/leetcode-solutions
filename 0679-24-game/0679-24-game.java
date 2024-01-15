class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            list.add((double)nums[i]);
        }
        return helper(list);
    }
    
    public boolean helper(List<Double> list){
        if(list.size() == 1){
            return Math.abs(list.get(0) - 24) <= 0.1;
        }else {
            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j < i; j++){
                    double a = list.get(i);
                    double b = list.get(j);

                    List<Double> vals = new ArrayList<>();
                    vals.addAll(Arrays.asList(a + b,
                                              a - b,
                                              b - a,
                                              a * b, 
                                              a / b, 
                                              b / a) );

                    List<Double> copy = new ArrayList<>(list);
                    copy.remove(i);
                    copy.remove(j);

                    for(double d : vals){
                        copy.add(d);
                        if(helper(copy)) return true;
                        copy.remove(copy.size()-1);
                    }
                }
            }
        }
        return false;
    }
}