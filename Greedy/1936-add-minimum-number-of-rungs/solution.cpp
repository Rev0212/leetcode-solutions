class Solution {
public:
    int addRungs(vector<int>& rungs, int dist) {
        int n = rungs.size();
        int prev = 0;
        int count =0;
        for(int i=0;i<n;i++)
        {
            int gap = rungs[i] - prev;
            if(gap > dist)
            {
                count += (gap-1)/dist;
            }
            prev = rungs[i];
        }
        return count;
    }
};
