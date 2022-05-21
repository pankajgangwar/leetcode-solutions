class VideoSharingPlatform {

    int videoId = 0;
        HashMap<Integer, Integer> likes = new HashMap<>();
        HashMap<Integer, Integer> disLikes = new HashMap<>();
        HashMap<Integer, Integer> views = new HashMap<>();
        HashMap<Integer, String> videosOnCloud = new HashMap<>();
        TreeSet<Integer> removedVideoIds = new TreeSet<>();
        public VideoSharingPlatform() {

        }

        public int upload(String video) {
            if(!removedVideoIds.isEmpty()){
                int available = removedVideoIds.pollFirst();
                videosOnCloud.put(available, video);
                return available;
            }
            videosOnCloud.put(videoId++, video);
            return videoId - 1;
        }

        public void remove(int videoId) {
            if(!videosOnCloud.containsKey(videoId)) return;
            videosOnCloud.remove(videoId);
            removedVideoIds.add(videoId);
        }

        public String watch(int videoId, int startMinute, int endMinute) {
            if(!videosOnCloud.containsKey(videoId)){
                return "-1";
            }
            views.put(videoId, views.getOrDefault(videoId, 0) + 1);
            String video = videosOnCloud.get(videoId);
            return video.substring(startMinute, Math.min(endMinute + 1, video.length()));
        }

        public void like(int videoId) {
            if(!videosOnCloud.containsKey(videoId)) return;
            likes.put(videoId, likes.getOrDefault(videoId, 0) + 1);
        }

        public void dislike(int videoId) {
            if(!videosOnCloud.containsKey(videoId)) return;
            disLikes.put(videoId, disLikes.getOrDefault(videoId, 0) + 1);
        }

        public int[] getLikesAndDislikes(int videoId) {
            if(!videosOnCloud.containsKey(videoId)) return new int[]{-1};
            int[] res = new int[2];
            res[0] = likes.getOrDefault(videoId, 0);
            res[1] = disLikes.getOrDefault(videoId, 0);
            return res;
        }

        public int getViews(int videoId) {
            if(!videosOnCloud.containsKey(videoId)) return -1;
            return views.getOrDefault(videoId, 0);
        }
}

/**
 * Your VideoSharingPlatform object will be instantiated and called as such:
 * VideoSharingPlatform obj = new VideoSharingPlatform();
 * int param_1 = obj.upload(video);
 * obj.remove(videoId);
 * String param_3 = obj.watch(videoId,startMinute,endMinute);
 * obj.like(videoId);
 * obj.dislike(videoId);
 * int[] param_6 = obj.getLikesAndDislikes(videoId);
 * int param_7 = obj.getViews(videoId);
 */