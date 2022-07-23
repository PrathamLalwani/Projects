class Solution:
    def romanToInt(self, s: str) -> int:
        x ={    
"I":1,
"V":5,
"X":10,
"L":50,
"C":100,
"D":500,
"M":1000
}
        sum = 0
        for i in range(len(s)-1,-1,-1):
            if(i+1<len(s) and x[s[i]]<x[s[i+1]]):
                continue
            sum = sum + x[s[i]]
            if(i>0 and x[s[i]]>x[s[i-1]]):
                sum-=x[s[i-1]]
                i=i-2
                
        return sum
                
        

x = Solution()
print(x.romanToInt("III"))
print(x.romanToInt("LVIII"))
print(x.romanToInt("MCMXCIV"))
