/*
@Author: Saraswati Mishra
 Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT. 
*/




class Solution {
    public int divide(int dividend, int divisor) {
        boolean flag=false;
         if((dividend<0 && divisor>0 )||(dividend>0 && divisor<0))
             flag=true;
        int count=1;
       
        long dividendL=(long)dividend;
        long divisorL=(long)divisor;
         dividendL=Math.abs(dividendL);
        divisorL=Math.abs(divisorL);
        if(divisorL==0)
            return Integer.MAX_VALUE;
        if(divisorL>dividendL)
            return 0;
        long countL=divide(dividendL, divisorL);
        if(countL> Integer.MAX_VALUE)
            count=(flag==true)?Integer.MIN_VALUE:Integer.MAX_VALUE;
        else
            count=(int)(flag==true?-countL:countL);
       
        return count;
        
    }
    
    long divide(long divd, long divr)
    {
        if(divd<divr)
            return 0;
        long sum=divr;
        long multiple=1;
        while(sum+sum<=divd)
        {
            sum+=sum;
            multiple+=multiple;
        }
        return multiple+divide(divd-sum, divr);
    }
}
