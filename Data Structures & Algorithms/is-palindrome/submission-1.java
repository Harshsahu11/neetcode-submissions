class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left<right){
            char charLeft = s.charAt(left);
            char charRight = s.charAt(right);

            if(!Character.isLetterOrDigit(charLeft)){
                left++;
                continue;
            }
            if(!Character.isLetterOrDigit(charRight)){
                right--;
                continue;
            }
            if(Character.toLowerCase(charLeft)!=Character.toLowerCase(charRight)) return false;
            left++;
            right--;
        }
        return true;
    }
}
