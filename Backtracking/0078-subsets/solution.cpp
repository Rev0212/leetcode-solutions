class Solution {
public:
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        vector<int> subset;
        generatesubset(nums, 0, subset, result);
        return result;
    }

private:
    void generatesubset(vector<int>& nums, int index, vector<int>& subset, vector<vector<int>>& result) {
        // Base case: when index reaches the end of nums
        if (index == nums.size()) {
            result.push_back(subset); // Add the current subset to the result
            return;
        }

        // Exclude the current element and move to the next index
        generatesubset(nums, index + 1, subset, result);

        // Include the current element and move to the next index
        subset.push_back(nums[index]);
        generatesubset(nums, index + 1, subset, result);
        subset.pop_back(); // Backtrack: remove the current element to restore the previous state of the subset
    }
};
