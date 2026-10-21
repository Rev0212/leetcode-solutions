class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size();
        if (n == 0) {
            return {-1, -1};
        }
        
        int first = -1, last = -1;
    
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                first = i;
                break;
            }
        }
    
        if (first == -1) {
            return {-1, -1};
        }
  
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == target) {
                last = i;
                break;
            }
        }
        
        return {first, last};
    }
};
