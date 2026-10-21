class Solution {
public:
    int findCircleNum(vector<vector<int>>& adj) {
        int n = adj.size();
        int ans = 0;
        vector<int> visited(n,0);
        for(int i=0;i<n;i++){
            if(!visited[i]){
                ans++;
                queue<int> q;
                visited[i] = 1;
                q.push(i);
                while(!q.empty()){
                int curr = q.front();
                q.pop();
                    for(int j=0; j<n;j++){
                            if(adj[curr][j] == 1 && !visited[j]){
                                q.push(j);
                                visited[j] = 1;
                            }
                    }
                }
            }
        }
        return ans;
    }
};
