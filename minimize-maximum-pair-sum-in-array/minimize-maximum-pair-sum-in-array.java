class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for(int i=0; i < nums.length; i++){
            int temp = nums[i] + nums[nums.length - i - 1];
            ret = Math.max(temp, ret);
        }
        
        return ret;
    }
}