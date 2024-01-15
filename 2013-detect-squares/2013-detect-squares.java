 class DetectSquares {
        HashMap<Integer, LinkedList<Integer>> xMap = new HashMap<>();
        HashMap<Integer, LinkedList<Integer>> yMap = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>();
        public DetectSquares() {
            
        }

        public void add(int[] point) {
            int x = point[0];
            int y = point[1];
            xMap.putIfAbsent(x, new LinkedList<>());
            yMap.putIfAbsent(y, new LinkedList<>());

            xMap.get(x).add(y);
            yMap.get(y).add(x);

            String s = x + "," + y;
            count.put(s, count.getOrDefault(s, 0) + 1);
        }

        public int count(int[] point) {
            int x = point[0];
            int y = point[1];
            int sum = 0;
            for(int y1 : xMap.getOrDefault(x, new LinkedList<>())){
                if(y1 == y ) continue;
                int d = Math.abs( y1 - y);
                if(x + d <= 1000){
                    sum += count.getOrDefault(getCoord(x + d, y), 0) * count.getOrDefault(getCoord(x + d, y1), 0);
                }
                if(x >= d){
                    sum += count.getOrDefault(getCoord(x - d, y), 0) * count.getOrDefault(getCoord(x - d, y1), 0);
                }
            }
            return sum;
        }
     
         public String getCoord(int x, int y){
             return x + "," + y;
         }
    }