class StockPrice {
        TreeMap<Integer, HashSet<Integer>> prices = new TreeMap<>();
        TreeMap<Integer, Integer> hMap = new TreeMap<>();
        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            if(hMap.containsKey(timestamp)){
                int oldPrice = hMap.get(timestamp);
                prices.get(oldPrice).remove(timestamp);
                if(prices.get(oldPrice).isEmpty()) {
                    prices.remove(oldPrice);
                }
            }
            hMap.put(timestamp, price);
            prices.putIfAbsent(price, new HashSet<>());
            prices.get(price).add(timestamp);
        }

        public int current() {
            return hMap.get(hMap.lastKey());
        }

        public int maximum() {
            return prices.lastKey();
        }

        public int minimum() {
            return prices.firstKey();
        }
    }


/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */