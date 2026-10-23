class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
         if (nums.empty()) {
            return 0;
        }
        int maxlen=0;
        int curlen=1;
        sort(nums.begin(),nums.end());
        for(int i=0;i<nums.size()-1;i++)
        {
            if(nums[i+1] == nums[i]+1)
            {
                curlen++;
            }
            else if (nums[i+1] == nums[i]) {
                continue;
            }
            else
            {
                maxlen = max(maxlen, curlen);
                curlen =1;
            }
        }
        maxlen = max(maxlen, curlen);
        return maxlen;

    }
};
