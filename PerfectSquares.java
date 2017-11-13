/*

279. Perfect Squares 

 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9. 

*/


class Solution {
    
    public int numSquares(int n) {
       int[] max=new int[n+1];
        max[0]=0;
        max[1]=1;
        int sq=(int)Math.floor(Math.sqrt(n));
        for(int i=0;i<=n;i++)
            max[i]=i;
        for(int i=1;i<=sq;i++)
        {
            for(int j=i*i;j<=n;j++)
            {
                max[j]=Math.min(max[j],max[j-i*i]+1);
            }
        }
        return max[n];
    }
    
    
}
