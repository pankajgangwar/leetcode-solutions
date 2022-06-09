class TopVotedCandidate {

        TreeMap<Integer, Integer> leadingAtTime = new TreeMap<>();
        TreeMap<Integer, LinkedList<Integer>> tMap = new TreeMap<>(Collections.reverseOrder());
        HashMap<Integer, Integer> votesMap = new HashMap<>();
        public TopVotedCandidate(int[] persons, int[] times) {
            for (int i = 0; i < times.length; i++) {
                int t = times[i];
                Integer p = persons[i];
                votesMap.put(p, votesMap.getOrDefault(p, 0) + 1);
                int voteCount = votesMap.get(p);
                tMap.putIfAbsent(voteCount, new LinkedList<>());
                if(tMap.containsKey(voteCount - 1)){
                    tMap.get(voteCount-1).remove(p);
                }
                tMap.get(voteCount).add(p);
                int maxVotes = tMap.firstKey();
                int leading = tMap.get(maxVotes).peekLast();
                leadingAtTime.put(t, leading);
            }
        }

        public int q(int t) {
            int maxVotes = leadingAtTime.floorKey(t);
            return leadingAtTime.get(maxVotes);
        }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */