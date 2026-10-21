class Solution {
public:
    bool divideArray(vector<int>& nums) {
        map<int,int> mpp;
        for(int i=0;i<nums.size();i++){
            mpp[nums[i]]++;
        }

        for (auto k : mpp){
            if(k.second % 2 != 0){
                return false;
                break;
            }
        }

        return true;
    }
};
