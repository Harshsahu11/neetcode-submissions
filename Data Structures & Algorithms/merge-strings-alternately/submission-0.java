class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int n1 = word1.length();
        int n2 = word2.length();
        int i;
        for( i = 0;i<Math.min(n1,n2);i++){
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            sb.append(ch1);
            sb.append(ch2);
        }
        if(n2>n1){
            while(i<n2){
                char ch2 = word2.charAt(i);
                sb.append(ch2);
                i++;
            }
        }
        else{
            while(i<n1){
                char ch1 = word1.charAt(i);
                sb.append(ch1);
                i++;
            }
        }
        return sb.toString();
    }
}