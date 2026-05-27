class Solution {
    public int lengthOfLastWord(String s) {
        s=s.trim();
        int n = s.length()-1;
        int i = n;
        while(i>=0 && s.charAt(i)!=' '){
            i--;
        }
        return n-i;
    }
}