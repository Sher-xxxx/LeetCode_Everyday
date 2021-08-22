class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] src = {0, 0};
        int distance = cal_distance(src, target);
        for(int[] ghost: ghosts){
            int temp_distance = cal_distance(ghost, target);
            if(temp_distance <= distance)
                return false;
        }
        return true;
    }

    int cal_distance(int[] src, int[] target){
        // 计算两点之间距离
        return Math.abs(src[0] - target[0]) + Math.abs(src[1] - target[1]);
    }
}