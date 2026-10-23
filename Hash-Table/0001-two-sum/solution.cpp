class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int,int>mpp;
        int remaining;
        int curr;
        for(int i=0;i<nums.size();i++)
        {
            curr=nums[i];
            remaining=target-curr;
            if(mpp.find(remaining) != mpp.end())
            {
                return{mpp[remaining],i};
            }
            mpp[curr] = i;
        }
        return {};
    }
};
