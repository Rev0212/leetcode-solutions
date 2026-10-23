class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int Profit = 0;
        int buyday = prices[0];
        for (int i =1;i<prices.size();i++)
        {
           int currentProfit = prices[i]-buyday;
            Profit = max(Profit,currentProfit);
            buyday=min(prices[i],buyday);
        }
        if(Profit > 0)
        {
            return Profit;
        }
        else
        {
            return 0;
        }
    }
};
