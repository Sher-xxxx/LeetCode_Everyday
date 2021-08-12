# LeetCode-最长回文子序列

## 题目描述

1. 输入：字符串s
2. 输出：s的最常回文子序列长度

## 算法思想

动态规划

如果s[i] = s[j]，那s[i]\[j] = s[i+1]\[j-1] + 2

如果s[i] != s[j]，那s[i]\[j] = Max(s[i+1]\[j] , s[i]\[j-1])

## 代码实现

```java
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = n-1; i >= 0; i--){
            dp[i][i] = 1;
            char c1 = s.charAt(i);
            for(int j = i+1; j < n; j++){
                char c2 = s.charAt(j);
                if(c1 == c2){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
```

