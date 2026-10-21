class Solution(object):
    def lengthOfLastWord(self, s):
        """
        :type s: str
        :rtype: int
        """
        word = s.split()
        if word:
            ans = len(word[-1])
            return ans
        else:
            return 0
