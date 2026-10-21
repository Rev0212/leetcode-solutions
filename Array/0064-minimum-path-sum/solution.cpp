class Solution {
private:
    int helper(vector<vector<int>>& grid,int m,int n,vector<vector<int>>&memo)
    {
        if(m==0 && n==0)
        {
            return grid[m][n];
        }
        if(m<0 || n<0)
        {
            return INT_MAX;
        }
        if(memo[m][n] != -1)
        {
            return memo[m][n];
        }
        int up = helper(grid,m-1,n,memo);
        int left = helper(grid,m,n-1,memo);
        memo[m][n] = grid[m][n] + min(up, left);
        return memo[m][n];
    }
public:
    int minPathSum(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> memo (m,vector<int>(n,-1));
        return helper(grid,m-1,n-1,memo);

    }
};
