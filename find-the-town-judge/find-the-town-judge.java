class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inTrust = new int[n+1]; // 信任i的人有几个
        int[] outTrust = new int[n+1];// i信任的人有几个

        for(int[] tr: trust){ 
            outTrust[tr[0]] += 1;
            inTrust[tr[1]] += 1;
        }
        for(int i = 1; i <= n; i++)
            if(inTrust[i] == n-1 && outTrust[i] == 0) return i;

        return -1;
    }
}