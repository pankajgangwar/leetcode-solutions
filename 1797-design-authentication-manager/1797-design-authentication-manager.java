class AuthenticationManager {

         int time = 0;
        List<Integer> tokens = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        public AuthenticationManager(int timeToLive) {
            time = timeToLive;
        }

        public void generate(String tokenId, int currentTime) {
            int expire = currentTime + time;
            map.put(tokenId, expire);
            tokens.add(expire);
        }

        public void renew(String tokenId, int currentTime) {
            if(map.containsKey(tokenId)){
                Integer expireTime = map.get(tokenId);
                if(expireTime > currentTime){
                    map.put(tokenId, currentTime + time);
                    tokens.remove(expireTime);
                    tokens.add((currentTime + time));
                }else{
                    map.remove(tokenId);
                }
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            /*map.entrySet().removeIf(e -> e.getValue() <= currentTime);
            return map.size();*/
            
            //System.out.println("CurrTime " + currentTime +  " tokens " + tokens.toString());
            int idx = Collections.binarySearch(tokens, currentTime);
            if(idx < 0){
                idx = ~idx;
                return tokens.size() - idx;
            }else{
                return tokens.size() - idx - 1;
            }
        }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */