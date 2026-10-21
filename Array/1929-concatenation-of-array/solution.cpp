class Solution {
public:
    vector<int> getConcatenation(vector<int>& nums) {
        int n = nums.size();
        int x=2*n;
        vector<int>ans(2*n);
        for(int i=0;i<n;i++)
        {
            ans[i]=nums[i];
        }
        for(int i=n;i<x;i++)
        {
            ans[i] = nums[i-n];
        }
        return ans;
    }
};
