/*
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome. 
*/
class Solution {
    public boolean isPalindrome(String s) {
        if(s.length()<2)
            return true;
        s=s.trim();
        s=s.toLowerCase();
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++)
        {
            if((s.charAt(i)>=97 && s.charAt(i)<=122) || (s.charAt(i)>=65 && s.charAt(i)<=90)||(s.charAt(i)>=48 && s.charAt(i)<=57))
                stack.push(s.charAt(i));
        }
        for(int i=0;i<s.length();i++)
        {
            if((s.charAt(i)>=97 && s.charAt(i)<=122) || (s.charAt(i)>=65 && s.charAt(i)<=90)||(s.charAt(i)>=48 && s.charAt(i)<=57))
            {
                Character c=s.charAt(i);
                //System.out.println(s.charAt(i)+" "+stack.peek());
                if(s.charAt(i)!=stack.pop())
                    return false;
            }
        }
        return true;
        
    }
}
