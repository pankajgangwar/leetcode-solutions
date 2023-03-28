class Solution {
    public String nextClosestTime(String time) {
        //return nextClosestTimeSol1(time);
        return nextClosestTimeS2(time);
    }
    public String nextClosestTimeS2(String time) {
        List<Integer> list = new ArrayList<>();
        String[] arr = time.split(":");
        for (int i = 0; i < arr.length; i++) {
            String x = arr[i];
            for (int j = 0; j < x.length(); j++) {
                int a = (int) x.charAt(j) - '0';
                list.add(a);
            }
        }
        HashSet<Integer> sets = new HashSet<>(list);
        if(sets.size() == 1 ) return time;

        String hr = arr[0];
        String min = arr[1];
        int mins = (Integer.parseInt(min) + 1) % 60;
        String m = String.format("%02d", mins);
        List<Integer> minsList =  new ArrayList<>();
        minsList.add((int)m.charAt(0) - '0');
        minsList.add((int)m.charAt(1) - '0');
        while (!list.containsAll(minsList)){
            minsList.clear();
            mins = (mins + 1) % 60;
            m = String.format("%02d", mins);
            minsList.add((int)m.charAt(0) - '0');
            minsList.add((int)m.charAt(1) - '0');
        }
        if(mins > Integer.parseInt(arr[1])){
            StringBuilder res = new StringBuilder();
            res.append(arr[0]);
            res.append(":");
            res.append(String.format("%02d", mins));
            return res.toString();
        }
        int hrs = (Integer.parseInt(hr) + 1) % 24;
        List<Integer> hrsList =  new ArrayList<>();
        String h = String.format("%02d", hrs);
        hrsList.add((int)h.charAt(0) - '0');
        hrsList.add((int)h.charAt(1) - '0');
        while (!list.containsAll(hrsList)){
            hrsList.clear();
            hrs = (hrs + 1) % 24;
            h = String.format("%02d", hrs);
            hrsList.add((int)h.charAt(0) - '0');
            hrsList.add((int)h.charAt(1) - '0');
        }
        StringBuilder out = new StringBuilder();
        out.append(String.format("%02d", hrs));
        out.append(":");
        out.append(String.format("%02d", mins));
        return out.toString();
    }

    public String nextClosestTimeSol1(String time) {
        char[] digits = new char[4];
        digits[0] = time.charAt(0);
        digits[1] = time.charAt(1);
        digits[2] = time.charAt(3);
        digits[3] = time.charAt(4);

        HashSet<String> timeSet = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        String candidate = digits[i]+ "" + digits[j] + "" + ":" + digits[k] + "" + digits[l];
                        System.out.println("candidate = " + candidate);
                        if(isValidTime(candidate)){
                            timeSet.add(candidate);
                        }
                    }
                }
            }
        }
        List<String> timesList = new ArrayList<>(timeSet);
        Collections.sort(timesList);
        int idx = timesList.indexOf(time);
        if(idx == timesList.size() - 1) return timesList.get(0);
        else return timesList.get(idx + 1);
    }

    private boolean isValidTime(String candidate) {
        int hrs = Integer.parseInt(candidate.split(":")[0]);
        int mins = Integer.parseInt(candidate.split(":")[1]);
        if(hrs >= 0 && hrs < 24 && mins >= 0 && mins < 60) return true;
        return false;
    }

}