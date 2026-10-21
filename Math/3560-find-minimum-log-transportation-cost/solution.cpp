class Solution {
public:
    long long minCuttingCost(int n, int m, int k) {
        long long cost=0;
        if(k>=n && k>=m){
            return 0;
        }
        if(n>k){
            cost += 1LL*(n-k)*(k);            
        }
        if(m>k){
             cost += 1LL*(m-k)*(k);            
        }

        return cost;
    }
};
