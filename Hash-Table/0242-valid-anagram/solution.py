class Solution(object):
    def isAnagram(self, s, t):
        if(len(s) != len(t)):
            return False
        wordS = sorted(s)
        wordT = sorted(t)
        for i in range (len(s)):
            if(wordS[i] != wordT[i]):
                return False
        return True
