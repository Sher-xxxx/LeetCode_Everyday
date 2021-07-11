class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for(int num: nums){
            map.put(sum, map.getOrDefault(sum, 0)+1);
            sum += num;
            res += map.getOrDefault(sum-goal, 0);
        }
        return res;
        
    }
}