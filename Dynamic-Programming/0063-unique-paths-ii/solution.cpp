class Solution {
private:
    int helper(vector<vector<int>>& obstacleGrid, int m, int n,vector<vector<int>>&memo)
    {
        // Base case
        if(m==0 && n==0)
        {
            return obstacleGrid[0][0] == 1 ? 0 : 1;  // Check if the start is blocked
        }
        if(m<0 || n<0)
        {
            return 0;
        }
        if(obstacleGrid[m][n] == 1)
        {
            return 0;
        }
        if(memo[m][n] != -1)
        {
            return memo[m][n];
        }
         
        int up = helper(obstacleGrid, m-1, n,memo);
        int left = helper(obstacleGrid, m, n-1,memo);

        memo[m][n] = left + up;
        return memo[m][n];
    }
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        int n = obstacleGrid[0].size();
        vector<vector<int>> memo(m, vector<int>(n, -1));
        return helper(obstacleGrid, m-1, n-1,memo);
    }
};
