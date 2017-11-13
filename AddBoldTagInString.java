/*

 616. Add Bold Tag in String


Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.

Example 1:

Input: 
s = "abcxyz123"
dict = ["abc","123"]
Output:
"<b>abc</b>xyz<b>123</b>"

Example 2:

Input: 
s = "aaabbcc"
dict = ["aaa","aab","bc"]
Output:
"<b>aaabbc</b>c"

Note:

    The given dict won't contain duplicates, and its length won't exceed 100.
    All the strings in input have length in range [1, 1000].


*/


class Solution {
    public String addBoldTag(String s, String[] dict) {
        if(dict.length==0)
            return s;
        ArrayList<Interval> list=new ArrayList<Interval>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<dict.length;i++)
        {
            int index=0;
            while(s.indexOf(dict[i], index)>=0)
            {
                int start=s.indexOf(dict[i], index);
                list.add(new Interval(start, start+dict[i].length()));
                index=start+1;
            }
        }
        Collections.sort(list, new Comparator<Interval>(){
           public int compare(Interval i1, Interval i2)
           {
               return i1.start-i2.start;
           }
        });
        for(int i=0;i<list.size();i++)
            System.out.println(list.get(i).start+" "+list.get(i).end);
        int start=0;
        ArrayList<Interval> mergeList=merge(list);
        for(int i=0;i<mergeList.size();i++)
        {
            sb.append(s.substring(start,mergeList.get(i).start));
            sb.append("<b>"+s.substring(mergeList.get(i).start, mergeList.get(i).end)+"</b>");
            start=mergeList.get(i).end;
        }
        if(start<s.length())
            sb.append(s.substring(start,s.length()));
        return sb.toString();
    }
    
    ArrayList<Interval> merge(ArrayList<Interval> list)
    {
        ArrayList<Interval> m=new ArrayList<Interval>();
        if(list.size()==0)
            return m;
        m.add(new Interval(list.get(0).start, list.get(0).end));
        for(int i=1;i<list.size();i++)
        {
            if(m.get(m.size()-1).end>=list.get(i).start && m.get(m.size()-1).end<list.get(i).end)
            {
                m.get(m.size()-1).end=list.get(i).end;
            }
            else if(m.get(m.size()-1).end<list.get(i).start)
                m.add(new Interval(list.get(i).start, list.get(i).end));
        }
        return m;
    }
    
    
    class Interval
    {
        int start;
        int end;
        
        Interval(int start, int end)
        {
            this.start=start;
            this.end=end;
        }
    }
}
