class Solution {
    public String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        if(len2>len1 || len1==0 || len2==0) return "";

        int[] map = new int[128];
        for(char c : t.toCharArray()) map[c]++;

        int left = 0;
        int right = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;
        int remaining = len2;

        while(right<len1){
            char rightChar = s.charAt(right);

            if(map[rightChar]>0) remaining--;

            map[rightChar]--;
            right++;

            while(remaining==0){
                if(right-left<minLength){
                    minLength=right-left;
                    minStart=left;
                }
                char leftChar = s.charAt(left);
                map[leftChar]++;

                if(map[leftChar]>0) remaining++;
                left++;
            }
        }
        return minLength==Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLength);
    }
}
