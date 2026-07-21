class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] freq = new int[26];
        for (char task : tasks) freq[task - 'A']++;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int count : freq) {
            if (count > 0) maxHeap.add(count);
        }
        Queue<int[]> waitingRoom = new LinkedList<>();
        int time = 0;
        while (!maxHeap.isEmpty() || !waitingRoom.isEmpty()) {
            time++;
            if (!maxHeap.isEmpty()) {
                int currentTaskFreq = maxHeap.poll();
                currentTaskFreq--;
                if (currentTaskFreq > 0) 
                    waitingRoom.add(new int[]{currentTaskFreq, time + n});
            }
            if (!waitingRoom.isEmpty() && waitingRoom.peek()[1] == time) 
                maxHeap.add(waitingRoom.poll()[0]);
        }
        return time;
    }
}
