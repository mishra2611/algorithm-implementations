/*
@Author: Saraswati Mishra
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18]. 
*/



/*Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> list=new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b)
            {
                return a.start-b.start;
            }
        });
        boolean[] isPresent=new boolean[intervals.size()];
        for(int i=0;i<intervals.size();i++)
        {
            for(int j=i+1;j<intervals.size();j++)
            {
                if(isPresent[i]==false && isPresent[j]==false)
                {
                    if(intervals.get(i).end>=intervals.get(j).start)
                {
                    if(intervals.get(i).start<=intervals.get(j).start && intervals.get(i).end>=intervals.get(j).end)
                        isPresent[j]=true;
                    else
                    {
                        intervals.get(i).end=intervals.get(i).end>intervals.get(j).end?intervals.get(i).end:intervals.get(j).end;
                    intervals.get(i).start=intervals.get(i).start<intervals.get(j).start?intervals.get(i).start:intervals.get(j).start;
                    isPresent[j]=true;
                    }
                    
                    //System.out.println(i+" "+j);
                }
                }
                
                    
            }
        }
        for(int i=0;i<isPresent.length;i++)
        {
            if(isPresent[i]==false)
            {
                list.add(new Interval(intervals.get(i).start,intervals.get(i).end));
            }
        }
        return list;
        
    }
}
