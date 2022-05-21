import java.util.*;
class TweetCounts {

    private Map<String, TreeMap<Integer, Integer>> map;
        public TweetCounts() {
 map = new HashMap<>();
        }

        public void recordTweet(String tweetName, int time) {
          map.putIfAbsent(tweetName, new TreeMap<>());
            TreeMap<Integer, Integer> timeMap = map.get(tweetName);
            timeMap.put(time, timeMap.getOrDefault(time, 0) + 1);
           
        }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
       List<Integer> res = new ArrayList<>();
            if(!map.containsKey(tweetName)) return res;
            int interval = 0, size = 0;
            if(freq.equals("minute")){
                interval = 60;
            }else if(freq.equals("hour")){
                interval = 3600;
            }else {
                interval = 86400;
            }
            size = ((endTime - startTime) / interval) + 1;
            int[] bucket = new int[size];
            TreeMap<Integer, Integer> timeMap = map.get(tweetName);
            for(Map.Entry<Integer, Integer> e : timeMap.subMap(startTime, endTime + 1).entrySet()){
                int index = (e.getKey() - startTime) / interval;
                bucket[index] += e.getValue();
            }
            for(int count : bucket) res.add(count);
            //System.out.println(res);
            return res;
    }
    
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */