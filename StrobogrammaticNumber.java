/*
246. Strobogrammatic Number

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

For example, the numbers "69", "88", and "818" are all strobogrammatic.


*/


class Solution {
    public boolean isStrobogrammatic(String num) {
        StringBuilder sb=new StringBuilder();
        String rev;
        for(int i=num.length()-1;i>=0;i--)
        {
            String curr=num.substring(i,i+1);
            
            if(curr.equals("6"))
                sb.append("9");
            else if(curr.equals("9"))
                sb.append("6");
            else if(curr.equals("0")||curr.equals("1")||curr.equals("8"))
                sb.append(curr);
            else
                sb.append("*");
        }
        rev=sb.toString();
        for(int i=0;i<num.length();i++)
        {
            if(rev.charAt(i)!=num.charAt(i))
                return false;
        }
        return true;
    }
}
