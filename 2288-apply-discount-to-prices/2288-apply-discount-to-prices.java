import java.text.DecimalFormat;
class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] arr = sentence.split(" ");
        double d = (double) discount / 100.0;
        DecimalFormat df = new DecimalFormat("0.00");
        for (int i = 0; i < arr.length; i++) {
            String s = arr[i];
            if(s.startsWith("$")){
                String price = s.substring(1);
                try{
                    double p = Double.parseDouble(price);
                    double pp = p * d;
                    double r = p - pp;
                    arr[i] = "$" + df.format(r);
                }catch (NumberFormatException e){

                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(String s : arr){
            res.append(s);
            res.append(" ");
        }
        return res.toString().trim();
    }
}