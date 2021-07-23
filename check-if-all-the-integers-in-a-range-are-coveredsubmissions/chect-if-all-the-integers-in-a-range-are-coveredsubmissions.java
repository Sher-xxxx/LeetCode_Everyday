class Solution {
    // 方法一
    public boolean isCovered_1(int[][] ranges, int left, int right) {
        boolean flag[] = new boolean[51];
        for(int[] range: ranges){
            for(int i=range[0]; i <= range[1]; i++){
                flag[i] = true;
            }
        }
        for(int i=left; i<=right; i++){
            if(flag[i] == false) return false;
        }

        return true;
    }
    // 方法二
    public boolean isCovered_2(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (a1, a2)->a1[0]-a2[0]);

        for(int range[]:ranges){
            int l = range[0];
            int r = range[1];
            if(l <= left && left <= r){
                left = r+1;
            }
        }
        return left>right;
    }
    // 方法三
    public boolean isCovered_3(int[][] ranges, int left, int right) {
        boolean flag[] = new boolean[51];
        for(int[] range: ranges){
            int L = Math.max(range[0], left);
            int R = Math.min(range[1], right);
            for(int i=L; i<=R; i++){
                flag[i] = true;
            }
        }

        for(int i=left; i<=right; i++){
            if(flag[i] == false) return false;
        }

        return true;
    }
}