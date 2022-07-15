class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        HashMap<String, ArrayList<String[]>> userMap = new HashMap<>();
        int n = username.length;
        for (int i = 0; i < n; i++) {
            String user = username[i];
            String url = website[i];
            String time = String.valueOf(timestamp[i]);
            userMap.putIfAbsent(user, new ArrayList<>());
            userMap.get(user).add(new String[]{url, time});
        }
        Map<String, Integer> count = new HashMap<>();
        String res = "";
        for (String key : userMap.keySet()) {
            HashSet<String> sets = new HashSet<>();
            List<String[]> list = userMap.get(key);
            Collections.sort(list, (a, b) -> Integer.parseInt(a[1]) - Integer.parseInt(b[1]));

            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    for (int k = j + 1; k < list.size(); k++) {
                        String str = list.get(i)[0] + " " + list.get(j)[0] + " " + list.get(k)[0];
                        if (!sets.contains(str)) {
                            count.put(str, count.getOrDefault(str, 0) + 1);
                            sets.add(str);
                        }
                        if (res.equals("") || count.get(res) < count.get(str) || (count.get(str) == count.get(res) && res.compareTo(str) > 0)) {
                            res = str;
                        }
                    }
                }
            }
        }
        System.out.println("res = " + res);
        String[] arr = res.split(" ");
        List<String> ans = new ArrayList<>(Arrays.asList(arr));
        return ans;
    }
}