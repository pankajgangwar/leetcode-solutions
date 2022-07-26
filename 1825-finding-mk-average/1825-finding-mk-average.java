class MKAverage {
    int m;
    int k;
    Queue<Integer> queue = new LinkedList<>();
    TreeMap<Integer, Integer> top = new TreeMap<>();
    TreeMap<Integer, Integer> bottom = new TreeMap<>();
    TreeMap<Integer, Integer> middle = new TreeMap<>();
    int countTop, countBottom;
    long middleSum;

    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        if (queue.size() == m) {
            int pop = queue.poll();
            if (top.containsKey(pop)) {
                remove(top, pop);
                countTop--;
            } else if (bottom.containsKey(pop)) {
                remove(bottom, pop);
                countBottom--;
            } else {
                remove(middle, pop);
                middleSum -= pop;
            }
        }
        add(middle, num);
        queue.add(num);
        middleSum += num;
        while (countTop < k && !middle.isEmpty()) {
            countTop++;
            middleSum -= middle.lastKey();
            add(top, remove(middle, middle.lastKey()));
        }
        while (!middle.isEmpty() && !top.isEmpty() && top.firstKey() < middle.lastKey()) {
            middleSum += top.firstKey();
            add(middle, remove(top, top.firstKey()));
            middleSum -= middle.lastKey();
            add(top, remove(middle, middle.lastKey()));
        }
        while (countBottom < k && !middle.isEmpty()) {
            countBottom++;
            middleSum -= middle.firstKey();
            add(bottom, remove(middle, middle.firstKey()));
        }
        while (!middle.isEmpty() && !bottom.isEmpty() && bottom.lastKey() > middle.firstKey()) {
            middleSum += bottom.lastKey();
            add(middle, remove(bottom, bottom.lastKey()));
            middleSum -= middle.firstKey();
            add(bottom, remove(middle, middle.firstKey()));
        }
    }

    public void add(TreeMap<Integer, Integer> map, int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    public int remove(TreeMap<Integer, Integer> map, int num) {
        map.put(num, map.get(num) - 1);
        if (map.get(num) == 0) map.remove(num);
        return num;
    }

    public int calculateMKAverage() {
        int sum = 0;
        int n = 0;
        return queue.size() == m ? (int) (middleSum / (m - 2 * k)) : -1;
    }
}
/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */
