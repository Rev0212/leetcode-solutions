class Solution {

public:
    void bfs(int i,int j,int rows, int cols , vector<vector<int>> & visited,vector<vector<char>>& grid ){
        if(i<0 || i>= rows || j<0 || j>= cols || (visited[i][j] == 1) || grid[i][j] == '0'){
            return;
        }
        visited[i][j] = 1;
        bfs(i+1,j,rows,cols,visited,grid);
        bfs(i-1,j,rows,cols,visited,grid);
        bfs(i,j+1,rows,cols,visited,grid);
        bfs(i,j-1,rows,cols,visited,grid);
    }


public:
    int numIslands(vector<vector<char>>& grid) {
        int rows = grid.size();
        int cols = grid[0].size();
        int count = 0;
        vector<vector<int>> visited (rows,vector<int>(cols,0));

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(visited[i][j] == 0 && grid[i][j] == '1'){
                    count++;
                    bfs(i,j,rows,cols,visited,grid);
                }
            }
        }

        return count;
    }
};
