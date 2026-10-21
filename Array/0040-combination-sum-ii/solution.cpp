#include <vector>
#include <algorithm>

class Solution {
private:
    void generateSubsets(std::vector<int>& nums, int index, std::vector<int>& subsets, std::vector<std::vector<int>>& result, int target, int currentSum) {
        if (currentSum == target) {
            result.push_back(subsets);
            return;
        }
        if (index >= nums.size() || currentSum > target) {
            return;
        }

        subsets.push_back(nums[index]);
        currentSum += nums[index];
        generateSubsets(nums, index + 1, subsets, result, target, currentSum);
        subsets.pop_back();
        currentSum -= nums[index];

        while (index + 1 < nums.size() && nums[index] == nums[index + 1]) {
            index++;
        }

        generateSubsets(nums, index + 1, subsets, result, target, currentSum);
    }

public:
    std::vector<std::vector<int>> combinationSum2(std::vector<int>& nums, int target) {
        std::vector<int> subsets;
        std::vector<std::vector<int>> result;

        
        std::sort(nums.begin(), nums.end());

        generateSubsets(nums, 0, subsets, result, target, 0);
        return result;
    }
};
