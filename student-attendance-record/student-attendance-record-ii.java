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