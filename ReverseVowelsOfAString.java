/*
345. Reverse Vowels of a String 


Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:
Given s = "hello", return "holle".

Example 2:
Given s = "leetcode", return "leotcede".

Note:
The vowels does not include the letter "y". 

*/


class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowel=new HashSet<Character>();
        vowel.add('a');vowel.add('A');
        vowel.add('e');vowel.add('E');
        vowel.add('i');vowel.add('I');
        vowel.add('o');vowel.add('O');
        vowel.add('u');vowel.add('U');
        StringBuilder sb=new StringBuilder(s);
        int start=0, end=s.length()-1;
        while(start<end)
        {
            if(vowel.contains(s.charAt(start)) && vowel.contains(s.charAt(end)))
               {
                   String tmp=s.substring(start, start+1);
                   sb.replace(start,start+1, s.substring(end, end+1));
                   sb.replace(end,end+1, tmp);
                   start++;end--;
               }
               else if(!vowel.contains(s.charAt(start)))
                start++;
               else if(!vowel.contains(s.charAt(end)))
                end--;
        }
    return sb.toString();
    }
}
