class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<1) return "";
        int left = 0;
        int right = 0;
        for(int i=0;i<s.length();i++){
            int len1 = checkPalin(s,i,i);
            int len2 = checkPalin(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len>right-left){
                left = i-(len-1)/2;
                right = i+len/2;
            }
        }
        return s.substring(left,right+1);
    }
    private int checkPalin(String s,int l,int r){
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
        }
        return r-l-1;
    }
}
