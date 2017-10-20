/*
@Author: Saraswati Mishra
621. Task Scheduler
Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.
*/
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] c=new int[26];
        int max=Integer.MIN_VALUE, count=0;
        for(int i=0;i<tasks.length;i++)
        {
            c[tasks[i]-'A']++;
        }
        for(int i=0;i<26;i++)
        {
            if(max<c[i])
            {
                max=c[i];
            }
        }
        for(int i=0;i<26;i++)
        {
            if(c[i]==max)
                count++;
        }
        return Math.max(max*(n+1)-n+(count-1),tasks.length);
    }
}
