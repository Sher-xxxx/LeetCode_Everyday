class Solution {
public:
    int findRepeatNumber(vector<int>& nums) {
        int N = nums.size();
        int *test = new int[N]{0};
        test[0]=-1;
        cout<<test[1];
        int i = 0;
        for(i=0; i<nums.size(); i++){
            if(nums[i] == 0 && test[nums[i]]!= -1)
                return 0;
            else if(nums[i] != 0 && test[nums[i]] != 0)
                return nums[i];
            else
                test[nums[i]] = nums[i];
        }
        return nums[i];
    }
};