class Solution {
private:
    int helper(int m,int n,vector<vector<int>>&memo)
    {
    
        // Base cases
        if (m == 0 && n == 0) {
            return 1;
        }
        if (m < 0 || n < 0) {
            return 0;
        }
        if (memo[m][n] != -1) {
            return memo[m][n];
        }
        
        
        int left = helper(m - 1, n,memo);
        int up = helper(m, n - 1,memo);

        memo[m][n] = left + up;
        return memo[m][n];
    }
public:
    int uniquePaths(int m, int n) 
    {   
        vector<vector<int>> memo(m, vector<int>(n, -1));
        return helper(m - 1, n - 1,memo);
    }
};
