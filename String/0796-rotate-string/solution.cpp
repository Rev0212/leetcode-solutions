class Solution {
public:
    bool rotateString(string s, string goal) {
        if(s.length() != goal.length())
        {
            return false;
        }
        string doubled = s+s;
        if( doubled.find(goal) != string::npos)
        {
            return true;
        }
        return false;
    }
};
