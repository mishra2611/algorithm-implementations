/*
@Author: Saraswati Mishra
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front. 
*/


class Solution {
    public int myAtoi(String str) {
        long l;
       
        str=str.trim();
        
        char[] c=str.toCharArray();
        int len=0;
        for(int i=0;i<c.length;i++)
        {
            if(i==0 && (c[i]=='+' || c[i]=='-'))
                len++;
            else if(c[i]>=48 && c[i]<=57)
                len++;
            else break;
        }
        str=str.substring(0,len);
        System.out.println("str"+str);
         if(str.length()==0|| str.equalsIgnoreCase("+")||str.equalsIgnoreCase("-"))
            return 0;
        java.math.BigInteger b=new java.math.BigInteger(str);
        long min=Integer.MIN_VALUE;
        long max=Integer.MAX_VALUE;
        
        if(java.math.BigInteger.valueOf(min).compareTo(b)>0)
            return Integer.MIN_VALUE;
        if(java.math.BigInteger.valueOf(max).compareTo(b)<0)
            return Integer.MAX_VALUE;
        
        return b.intValue();
        
    }
}
