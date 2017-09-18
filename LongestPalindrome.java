/*
Author:     smishra, saraswatimishra18@gmail.com
 Date:       Aug 20, 2017
 Problem:    Longest Palindrome
 Difficulty: Easy
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

*/

class Solution {
    public int longestPalindrome(String s) {
        char[] c=s.toCharArray();
        Arrays.sort(c);
        boolean isMiddle=false;int count=0, finalCount=0;
        int start=0,end=1;
        if(c.length==1)
            return 1;
        while(end<=c.length)
        {
            
            if(end==c.length || c[start]!=c[end])
            {
                count=end-start;
                if(count%2==0)
                    finalCount+=count;
                else
                {
                    if(isMiddle==false)
                        isMiddle=true;
                    finalCount+=end-start-1;
                }
                    
                start=end;
            }
           end++;
           count=0;     
        }
         
        if(isMiddle)
            finalCount++;
        
            return finalCount;
            
    }
}
