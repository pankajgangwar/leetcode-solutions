class SORTracker {

    int query = 1;
        PriorityQueue<Item> top = new PriorityQueue<>((a,b) -> a.score == b.score ? -a.name.compareTo(b.name) : a.score - b.score);
        PriorityQueue<Item> bottom = new PriorityQueue<>((a,b) -> a.score == b.score ? a.name.compareTo(b.name) : -a.score + b.score);
        public SORTracker() {

        }

        public void add(String name, int score) {
            top.offer(new Item(score,name));
            if(top.size() >= query){
                bottom.offer(top.poll());
            }
        }

        public String get() {
            query += 1;
            Item it = bottom.poll();
            top.offer(it);
            return it.name;
        }
}

class Item{
        int score;
        String name;
        public Item(int score, String name){
            this.score = score;
            this.name = name;
        }
    }

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */