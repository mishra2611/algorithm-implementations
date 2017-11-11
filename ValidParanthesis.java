/*

 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]


*/


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> str=new ArrayList<String>();
        bt(new StringBuilder(),n, n,n*2,0, str);
        return str;
    }
    
    void bt(StringBuilder sb, int start,int end, int total,int level, List<String> str)
    {
        if(level==total)
        {
            //System.out.println(sb.toString());
            if(start==0 && end==0)
            {
                str.add(sb.toString());
            }
            return;
        }
        if(start==end)
        {
            sb.append("(");
            bt(sb,start-1,end,total,level+1,str);
            sb.deleteCharAt(sb.length()-1);
        }
        else if(start<end)
        {
            sb.append("(");
            bt(sb,start-1,end,total,level+1,str);
            sb.deleteCharAt(sb.length()-1);
            sb.append(")");
            bt(sb,start,end-1,total,level+1,str);
            sb.deleteCharAt(sb.length()-1);
            
        }
        return;
    }
}
