class Solution {
public:
    bool check(vector<int>& nums) {
    int n = nums.size();
    if (n <= 1) {
        return true;
    }
    
    int rotation_point = 0;
    for (int i = 0; i < n - 1; ++i) {
        if (nums[i] > nums[i + 1]) {
            rotation_point = i + 1;
            break;
        }
    }
    
    
    if (rotation_point == 0) {
        return true;
    }
  
    for (int i = rotation_point; i < n - 1; ++i) {
        if (nums[i] > nums[i + 1]) {
            return false;
        }
    }
    
    if (nums[n - 1] > nums[0]) {
        return false;
    }
    
    return true;
}
};
