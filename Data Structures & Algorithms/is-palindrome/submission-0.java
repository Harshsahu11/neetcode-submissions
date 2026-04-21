class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch)) sb.append(Character.toLowerCase(ch));
        }
        String newStr = sb.toString();

        int i=0,j=newStr.length()-1;
        while(i<j){
            if(newStr.charAt(i)!=newStr.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
