class Solution {
private:
    int hellper(int &small ,int &big)
    {
        int rem = big%small;
        while(rem != 0)
        {
        big=small;
        small=rem;
        rem = big%small;
        }
        return small;
    }
public:
    int findGCD(vector<int>& nums) {
        int big=*max_element(nums.begin(),nums.end());
        int small=*min_element(nums.begin(),nums.end());
        int ans=hellper(small,big);
        return ans;
    }
};
