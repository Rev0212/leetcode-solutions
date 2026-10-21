class Solution {
public:
    bool isPalindrome(string s) {
            string newS;
            for (char c : s)
            {
                if (isalnum(c)) 
               {
                newS += tolower(c);
               } 
            }
            int left = 0;
            int right = newS.size()-1;
            while(left<right)
            {
                if(newS[left] != newS[right])
                {
                    return false;
                }
                right--;
                left++;
            }
            return true;

        }
};
