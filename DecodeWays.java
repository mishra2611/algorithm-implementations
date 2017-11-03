/*
 A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26

Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2. 
*/




class Solution {
    public int numDecodings(String s) {
        if(s==null|| s.length()==0)
            return 0;
        char[] c=s.toCharArray();
        int[] dp=new int[s.length()+1];
        for(int i=0;i<dp.length;i++)
        {
            if(i==0 || (i==1 && c[i-1]!='0'))
                dp[i]=1;
            else if(i==1 && c[i-1]=='0')
                dp[i]=0;
            else
            {
                if(c[i-1]=='0')
                {
                    if(valid(c,i-2,i-1))
                        dp[i]=dp[i-2];
                    else
                        dp[i]=0;
                }
                else
                {
                   if(valid(c,i-2,i-1))
                    dp[i]=dp[i-1]+dp[i-2];
                else
                    dp[i]=dp[i-1]; 
                }
                
            }
        }
        return dp[dp.length-1];
    }
    
    boolean valid(char[] c, int start, int end)
    {
        int i=c[start]-48;
        int j=c[end]-48;
        if(i==0)
            return false;
        if((i*10+j)<=26 && (i*10+j)>0)
            return true;
        return false;
    }
}
