/*
@Author: Saraswati Mishra
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2. 
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */

class Solution {
    
    public int minMeetingRooms(Interval[] intervals) {
        boolean[] isVisited=new boolean[intervals.length];
        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval x, Interval y){
                return x.start-y.start;
            }
        });
        int endTime, count=0, max=0;
        while(count<intervals.length)
        {
            endTime=Integer.MIN_VALUE;int i=0;
            while(i<intervals.length)
            {
                if(isVisited[i]==false)
                {
                    if(intervals[i].start>=endTime)
                    {
                        endTime=intervals[i].end;
                        isVisited[i]=true;
                        count++; 
                    }
                }
                i++;
            }
            max++;
        }
         return max;
}
}
