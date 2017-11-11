/*
 Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:

Input: "aba"
Output: True

Example 2:

Input: "abca"
Output: True
Explanation: You could delete the character 'c'.

*/



class Solution {
    public boolean validPalindrome(String s) {
        if(s.length()<3)
            return true;
        char[] c=s.toCharArray();
        int len=s.length();
        for(int i=0;i<s.length()/2;i++)
        {
            if(c[i]!=c[len-i-1])
                return checkPalindrome(s,i,len-i-2)|| checkPalindrome(s,i+1,len-i-1);
        }
        return true;
    }
    boolean checkPalindrome(String s, int start, int end)
    {
        char[] c=s.toCharArray();
        while(start<end)
        {
            if(c[start++]!=c[end--])
                return false;
        }
        return true;
    }
    
}
