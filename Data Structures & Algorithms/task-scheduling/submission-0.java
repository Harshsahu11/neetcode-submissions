class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxFreqCount = 0;

        for(char task : tasks){
            freq[task-'A']++;
            if(freq[task-'A']>maxFreq) maxFreq = freq[task-'A'];
        }

        for(int fr : freq){
            if(fr==maxFreq) maxFreqCount++;
        }
        int formulaTime = (maxFreq-1)*(n+1)+maxFreqCount;
        return Math.max(tasks.length,formulaTime);
    }
}
