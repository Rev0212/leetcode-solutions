#include <vector>
#include <algorithm>

using namespace std;

class Solution {
private:
    void generateSubsets(vector<int>& candidates, int index, vector<int>& subsets, vector<vector<int>>& results, int target) {
        if(index==candidates.size())
        {
            if(target==0)
            {
                results.push_back(subsets);
            }
            return;
        }
        if(candidates[index] <= target )
        {
        subsets.push_back(candidates[index]);
        generateSubsets(candidates,index,subsets,results,target-candidates[index]);
        subsets.pop_back();
        }
        generateSubsets(candidates,index+1,subsets,results,target);
    }

public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> subsets;
        vector<vector<int>> results;
        generateSubsets(candidates, 0, subsets, results, target);
        return results;
    }
};
