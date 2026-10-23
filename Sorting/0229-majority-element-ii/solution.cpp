class Solution {
public:
    vector<int> majorityElement(vector<int>& nums) {
        int el1 = INT_MIN;
        int el2 = INT_MIN;
        int cnt1 = 0,cnt2 = 0;
        int n = nums.size();
        int target = n/3;
        for(int i=0;i<n;i++){
            if(cnt1 == 0 && el2 != nums[i] ){
                el1 = nums[i];
                cnt1++;
            } 
            else if(cnt2 == 0 && el1 != nums[i]){
                el2 = nums[i];
                cnt2++;
            }
            else if(nums[i] == el1){
                cnt1++;
            }
            else if(nums[i] == el2){
                cnt2++;
            }
            else{
            cnt1--;
            cnt2--;
            }
        }
        vector<int> ans;

        cnt1 = cnt2 = 0;
        for (int num : nums) {
            if (num == el1) cnt1++;
            else if (num == el2) cnt2++;
        }
        if (cnt1 > n / 3) ans.push_back(el1);
        if (cnt2 > n / 3) ans.push_back(el2);

        return ans;
    }
};
