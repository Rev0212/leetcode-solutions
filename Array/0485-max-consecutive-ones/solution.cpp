class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
       int maxConsecutiveOnes = 0;
        int currentConsecutiveOnes = 0;
        
        for (int i = 0; i < nums.size(); ++i) {
            if (nums[i] == 1) {
                currentConsecutiveOnes++;
                maxConsecutiveOnes = max(maxConsecutiveOnes, currentConsecutiveOnes);
            } else {
                currentConsecutiveOnes = 0;
            }
        }
        
        return maxConsecutiveOnes;
    }
    
};
