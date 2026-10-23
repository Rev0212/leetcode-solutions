class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int n = nums.size();
        int majorityElement = nums[0];
        int count = 0;
        for(int i=0;i<n;i++){
            if(count == 0){
                majorityElement = nums[i];
            }
            if(majorityElement == nums[i]){
                count++;
            }
            else{
                count --;
            }
        }
        return majorityElement;

    }
};
