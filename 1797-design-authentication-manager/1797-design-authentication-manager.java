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
                int expireTime = map.get(tokenId);
                if(expireTime > currentTime){
                    map.put(tokenId, currentTime + time);
                    tokens.add((currentTime + time));
                }else{
                    map.remove(tokenId);
                }
            }
        }

        public int countUnexpiredTokens(int currentTime) {
            map.entrySet().removeIf(e -> e.getValue() <= currentTime);
            return map.size();
        }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */