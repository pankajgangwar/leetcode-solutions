class Solution {

      public String countOfAtoms(String formula) {
        StringBuilder out = new StringBuilder();
        TreeMap<String, Integer> map = helper(formula);
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            if (e.getValue() > 1) {
                out.append(e.getKey()).append(e.getValue());
            } else {
                out.append(e.getKey());
            }
        }
        return out.toString();
    }

    public TreeMap<String, Integer> helper(String formula) {
        TreeMap<String, Integer> map = new TreeMap<>();
        int n = formula.length();
        for (int i = 0; i < formula.length(); ) {
            char ch = formula.charAt(i);
            if (Character.isUpperCase(ch)) {
                int j = i + 1;
                while (j < n && !Character.isUpperCase(formula.charAt(j))
                        && !Character.isDigit(formula.charAt(j))
                        && formula.charAt(j) != '(') {
                    j += 1;
                }
                if (j < n && Character.isDigit(formula.charAt(j))) {
                    int d = 0;
                    int k = j;
                    while (j < n && Character.isDigit(formula.charAt(j))){
                        d = d * 10 + formula.charAt(j++) - '0';
                    }
                    String f = formula.substring(i, k);
                    map.put(f, map.getOrDefault(f, 0) + d);
                } else if (j < n && Character.isUpperCase(formula.charAt(j))) {
                    String f = formula.substring(i, j);
                    map.put(f, map.getOrDefault(f, 0) + 1);
                }else if(j < n && formula.charAt(j) == '('){
                    String f = formula.substring(i, j);
                    map.put(f, map.getOrDefault(f, 0) + 1);
                }
                else if (j == n) {
                    String f = formula.substring(i, j);
                    map.put(f, map.getOrDefault(f, 0) + 1);
                }
                i = j;
            } else if (ch == '(') {
                int open = 1, close = 0;
                int j = i + 1;
                while (j < n && open != close) {
                    if (formula.charAt(j) == '(') {
                        open += 1;
                    } else if (formula.charAt(j) == ')') {
                        close += 1;
                    }
                    j++;
                }
                int mul = 0;
                String sub = formula.substring(i + 1, j - 1);
                while (j < n && Character.isDigit(formula.charAt(j))) {
                    mul = mul * 10 +  formula.charAt(j++) - '0';
                }
                if(mul == 0) mul = 1;
                TreeMap<String, Integer> subMap = helper(sub);
                for (Map.Entry<String, Integer> e : subMap.entrySet()) {
                    String f = e.getKey();
                    int a = e.getValue() * mul;
                    map.put(f, map.getOrDefault(f, 0) + a);
                }
                i = j;
            }
        }
        return map;
    }
}
