class Solution {
public:
    void sortColors(vector<int>& nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i=0;i<nums.size();i++){
            if(nums[i] == 0){
                count0++;
            }
            else if(nums[i] == 1){
                count1++;
            }
            else{
                count2++;
            }
        }

        int i = 0;
        for (; i < count0; i++) nums[i] = 0;
        for (; i < count0 + count1; i++) nums[i] = 1;
        for (; i < nums.size(); i++) nums[i] = 2;
        
    }
};
