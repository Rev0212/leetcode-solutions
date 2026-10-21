class Solution {
public:
    int numJewelsInStones(string jewels, string stones)
    {
    unordered_map<char, int> stonemap;
    for(int i=0;i<stones.size();i++)
    {
        stonemap[stones[i]]++;
    }
    int jewelCount = 0;
        for(int i = 0; i < jewels.size(); i++) 
        {
            if(stonemap.find(jewels[i]) != stonemap.end()) 
            {
                jewelCount += stonemap[jewels[i]];
            }
        }
         return jewelCount; 
        }
};
