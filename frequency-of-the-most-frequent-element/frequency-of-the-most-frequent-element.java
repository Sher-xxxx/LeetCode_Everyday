class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max=0, temp=0;
        for(int i=0, j=0; j<nums.length; j++){
            while(nums[j]*(j-i)-temp > k){
                // 如果需要加的值超出了k，那左边界就往右移
                temp -= nums[i++];
            }
            temp += nums[j];
            max = Math.max(max, j-i+1);
        }
        return max;
    }
}