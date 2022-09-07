class Solution {
    class Room {
        int number;
        int start, end;
        public Room(int number, int start, int end) {
            this.number = number;
            this.start = start;
            this.end = end;
        }
    }
    
    public int mostBooked(int n, int[][] meetings) {
        int[] freq = new int[n];
        PriorityQueue<Room> booked = new PriorityQueue<>((a,b) -> a.end == b.end ? a.number - b.number : a.end - b.end);
        PriorityQueue<Integer> available = new PriorityQueue<>();
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int i = 0; i < n; i++) {
            available.offer(i);
        }
        for (int i = 0; i < meetings.length; i++) {
            int[] meeting = meetings[i];
            while (!booked.isEmpty() && booked.peek().end <= meeting[0]){
                available.offer(booked.poll().number);
            }
            if(!available.isEmpty()){
                int roomNumber = available.poll();
                freq[roomNumber] += 1;
                booked.offer(new Room( roomNumber, meeting[0], meeting[1]));
            }else{
                Room r = booked.poll();
                r.start = r.end + 1;
                r.end = r.end + meeting[1] - meeting[0];
                booked.offer(r);
                freq[r.number] += 1;
            }
        }
        int maxI = 0;
        for (int i = 1; i < n; i++) {
            if(freq[i] > freq[maxI]){
                maxI = i;
            }
        }
        return maxI;
    }
}