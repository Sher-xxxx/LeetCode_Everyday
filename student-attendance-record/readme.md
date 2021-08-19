# LeetCode-学生出勤记录

## 出勤记录-1

### 题目描述

1. 输入：字符串s
2. 规则：不能超过两个A（Absent），不能有连续三个或三个以上的L（Late），P（Present）不造成影响。同时满足以上三个条件的返回true，否则返回false。
3. 输出：返回是否能获得奖励

#### 算法思想

从头遍历s中每个字符，计算A和L出现个数，L如果中断则L的count归零

#### 代码实现

```java
class Solution {
    public boolean checkRecord(String s) {
        int n = s.length();
        int absents = 0, lates = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == 'A'){
                if(++absents == 2)
                    return false;
            }

            if(s.charAt(i) == 'L'){
                if(++lates == 3)
                    return false;
            }else{
                lates = 0;
            }
        }
        return true;
    }
}
```

## 出勤记录-2

### 题目描述

1. 输入：字符个数整数n
2. 输出：根据题目1的规则，计算满足条件的字符串的个数

#### 算法思想

**动态规划dp**

dp[i]\[j][k]表示前 i 天有 j 个 'A' 且 结尾 有连续 k 个 'L' 的数量，

1. i=0：dp[0]\[0][0] = 1 

2. 1<= i <= n，其状态由dp[i-1]\[][]得到。当前i,j,k会加上结尾是A,L,P的每种情况

   1. 结尾是P：结尾k=0，j不变，对于0<= j <= 1，（j==2就不符合条件了）会有

      dp[i]\[j][0] = dp[i]\[j][0]+sum(dp[i-1]\[j][k])

   2. 结尾是A：结尾k=0，j+1，这时候j只有0的时候才能加上，新来了一个A，j变为1，结尾不是P，K变为0

      dp[i]\[1][0] = dp[i]\[1][0] + sum(dp[i-1]\[0][k])

   3. 结尾是L：结尾k+1，之前的k要小于等于2，j小于等于1

      dp[i]\[j][k] = dp[i]\[j][k] + sum(dp[i-1]\[j][k-1])

   4. TIPS: 由于数量太大需要取模，这时 += 不可以用，所以上面公式里面会有两个一样的

#### 代码实现

```java
class Solution {
    public int checkRecord(int n) {
        int MOD = (int)1e9+7;
        int ans = 0;
        int[][][] dp = new int[n+1][2][3];
        dp[0][0][0] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= 1; j++){
                for(int k = 0; k <= 2; k++){
                    dp[i][j][0]= (dp[i][j][0] + dp[i-1][j][k]) % MOD;
                }
            }

            for(int k = 0; k <= 2; k++){
                dp[i][1][0] = (dp[i][1][0] + dp[i-1][0][k]) % MOD;
            }

            for(int j = 0; j <= 1; j++){
                for(int k = 1; k <= 2; k++){
                    dp[i][j][k] = (dp[i-1][j][k-1]) % MOD;
                }
            }
        }
        for(int j=0; j <= 1; j++){
            for(int k = 0; k <= 2; k++){
                ans = (ans+dp[n][j][k]) % MOD;
            }
        }

        return ans%MOD;
    }
}
```

代码改进：

```java
class Solution {
    public int checkRecord(int n) {
        int MOD = (int)1e9+7;
        int ans = 0;
        int[][] dp = new int[2][3];
        dp[0][0] = 1;
        // i, j, k : 第i天，j次缺勤，最后有k次迟到
        for(int i=0; i < n; i++){
            int[][] dpNew = new int[2][3];
            // P结尾
            for(int j=0; j < 2; j++){
                for(int k=0; k < 3; k++){
                    dpNew[j][0] = (dpNew[j][0] + dp[j][k]) % MOD;
                }
            }
            // A结尾
            for(int k=0; k < 3; k++){
                dpNew[1][0] = (dpNew[1][0] + dp[0][k]) % MOD;
            }
            // L结尾
            for(int j=0; j < 2; j++){
                for(int k = 1; k <= 2; k++){
                    dpNew[j][k] = (dpNew[j][k] + dp[j][k-1]) % MOD;
                }
            }
            dp = dpNew;
        }
        for(int j=0; j < 2; j++){
            for(int k=0; k < 3; k++){
                ans = (ans + dp[j][k]) % MOD;
            }
        }

        return ans;
    }
}
```

