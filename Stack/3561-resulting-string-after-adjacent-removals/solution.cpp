class Solution {
public:
    bool check(char a, char b){
        return (abs(a-b) == 1 || (a == 'a' && b =='z') || (a == 'z' && b =='a') );
    }
    string resultingString(string s) {
        string stack;
        for(auto c:s){
            if(!stack.empty() && check(stack.back(),c)){
                stack.pop_back();
            }
            else{
                stack.push_back(c);
            }
        }

        return stack;
    }
};
