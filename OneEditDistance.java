/*
161. One Edit Distance

Given two strings S and T, determine if they are both one edit distance apart.
*/


class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if(Math.abs(s.length()-t.length())>1)
            return false;
        if(s.equals(t))
            return false;
       for(int i=0;i<s.length();i++)
       {
           if(i<t.length() && s.charAt(i)!=t.charAt(i))
               return isValid(s,i+1,t,i+1)|| isValid(s,i,t,i+1)|| isValid(s,i+1,t,i);
       }
        if(s.length()==t.length())
            return false;
        return true;
    }
    
    boolean isValid(String s, int i, String t, int j)
    {
        if(i>=s.length() && j>=t.length())
            return true;
        System.out.println("String1:"+s+"Index1:"+i+"String2:"+t+"Index2:"+j);
        if(s.substring(i,s.length()).equals(t.substring(j,t.length())))
            return true;
        return false;
    }
}
