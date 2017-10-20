/*
@Author: Saraswati Mishra
67. Add Binary 
 Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100". 
*/

class Solution {
    public String addBinary(String a, String b) {
        String result="";
        char[] c1;
        char[] c2;
        char[] res;
        int len1=a.length(),len2=b.length();
        if(len1==0 && len2==0)
            return result;
        if(len1==0)
            return b;
        if(len2==0)
            return a;
        if(len1>=len2)
        {
            c2=new char[len1];
            res=new char[len1+1];
            c1=a.toCharArray();
            int diff=len1-len2;
            for(int i=0;i<len1;i++)
            {
                if(i<diff)
                    c2[i]='0';
                else
                    c2[i]=b.charAt(i-diff);
            }
        }
        else
        {
            c1=new char[len2];
            res=new char[len2+1];
            c2=b.toCharArray();
            int diff=len2-len1;
            for(int i=0;i<len2;i++)
            {
                if(i<diff)
                    c1[i]='0';
                else
                    c1[i]=a.charAt(i-diff);
            }
        }
        int carry=0;
        for(int i=res.length-1;i>0;i--)
        {
            if(c1[i-1]=='0' && c2[i-1]=='0')
            {
                if(carry==0)
                    res[i]='0';
                else{
                    res[i]='1';carry=0;
                }
            }
            else if((c1[i-1]=='1' && c2[i-1]=='0') ||(c1[i-1]=='0' && c2[i-1]=='1'))
            {
                if(carry==0)
                    res[i]='1';
                else
                {
                    res[i]='0';carry=1;
                }
            }
            else
            {
                if(carry==0)
                    res[i]='0';
                else
                    res[i]='1';
                carry=1;
            }
        }
        if(carry==1){
            res[0]='1';
            return new String(res);
        }     
        else
            res[0]='0';
        return new String(res,1,res.length-1);
    }
}
