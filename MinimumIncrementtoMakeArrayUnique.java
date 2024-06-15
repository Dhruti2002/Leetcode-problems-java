class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int min_val = 0;
        for(int i=1; i<nums.length; i++){
            if (nums[i - 1] >= nums[i]){
                int diff = nums[i-1] - nums[i] + 1;
                min_val += diff;
                nums[i] += diff;
            }
        }
        return min_val;
    }
}
