class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) 
    {
        vector<int>ans(nums.size());
        int posIndex=0;
        int negIndex=1;
        for(int num:nums )
        {
            if(num>0){
                ans[posIndex] = num;
                posIndex+=2;
            }
            else
            {
                ans[negIndex] = num;
                negIndex +=2;
            }
        }

            
        return ans;
    }
};
