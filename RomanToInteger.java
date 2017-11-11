
/*

13. Roman to Integer 

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

*/


class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map=new HashMap<Character, Integer>();
        if(s==null||s.length()==0)
            return 0;
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        int sum=0;
        sum=sum+map.get(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--)
        {
            if(map.get(s.charAt(i))<map.get(s.charAt(i+1)))
                sum=sum-map.get(s.charAt(i));
            else
                sum=sum+map.get(s.charAt(i));
        }
        return sum;
    }
}
