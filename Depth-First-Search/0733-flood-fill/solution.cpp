class Solution {

public:
    void dfs (int i,int j,int rows, int cols, vector<vector<int>>& image , int sourceColor,int color) {
        if(i<0 || i>= rows || j<0 || j>= cols || image[i][j] != sourceColor)
            return;
        image[i][j] = color;
        dfs(i+1,j,rows,cols,image,sourceColor,color);
        dfs(i-1,j,rows,cols,image,sourceColor,color);
        dfs(i,j+1,rows,cols,image,sourceColor,color);
        dfs(i,j-1,rows,cols,image,sourceColor,color);
    }

public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int rows = image.size();
        int cols = image[0].size();
        int sourceColor = image[sr][sc];
        

        if(sourceColor == color){
            return image;
        }
        
        dfs(sr,sc,rows,cols,image,sourceColor,color);

        return image;
    }
};
