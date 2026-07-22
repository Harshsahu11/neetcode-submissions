class Solution {
    private static final String[] KEYPAD = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) return result;
        backtrack(0, digits, new StringBuilder(), result);
        return result;
    }
    public void backtrack(int index,String digits,StringBuilder curr,List<String> ans){
        if(index==digits.length()){
            ans.add(curr.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = KEYPAD[digit-'0'];
        for(char letter : letters.toCharArray()){
            curr.append(letter);
            backtrack(index+1,digits,curr,ans);
            curr.deleteCharAt(curr.length()-1);
        }
    }
}
