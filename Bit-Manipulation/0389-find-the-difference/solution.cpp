class Solution {
public:
    char findTheDifference(string s, string t) {  
        int sum1 = 0;
        int sum2 = 0;   
        for(int i=0;i<s.size();i++)
        {
            int asciVal = int(s[i]);
            sum1 += asciVal;
        }
        for(int i=0;i<t.size();i++)
        {
            int asciVal = int(t[i]);
            sum2 += asciVal;
        }
        int diff = sum2-sum1;
        return char(diff);
    }
};
