class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        sort(strs.begin(),strs.end());
        string first = strs[0];
        string last = strs[strs.size()-1];
        int i = 0;
        while(i<first.size() && i<last.size() && first[i] == last[i]){
            i++;
        }
        string ans;
        for(int j=0;j<i;j++){
            ans.push_back(first[j]);
        }
        return ans;
    }
};
