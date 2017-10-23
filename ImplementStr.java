/* Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack. */

class Solution {
    public int strStr(String haystack, String needle) {
        char[] hs=haystack.toCharArray();
        char[] nd=needle.toCharArray();
        if(hs.length==0 && nd.length==0)
            return 0;
        if(nd.length==0)
            return 0;
        if(hs.length<nd.length)
            return -1;
        int hs_len=hs.length;
        int nd_len=nd.length;
        for(int i=0;i<=hs_len-nd_len;i++)
        {
            if(hs[i]==nd[0])
            {
                if(haystack.substring(i,i+nd_len).equals(needle))
                    return i;
            }
        }
        return -1;
    }
}
