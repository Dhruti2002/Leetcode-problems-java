/*An array is monotonic if it is either monotone increasing or monotone decreasing.
An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
Given an integer array nums, return true if the given array is monotonic, or false otherwise.*/

class Solution {
    public boolean isMonotonic(int[] nums) {
        int n= nums.length;
        if (n==0) {
            return true;
        }
        int first = nums[0];
        int last = nums[n-1];

        if (first > last) {
            for(int i=0; i<n-1; i++){
                if (nums[i] < nums[i+1]){
                    return false;
                }
            }
        }
        else if (first == last) {
            for(int i=0; i<n-1; i++){
                if (nums[i] != nums[i+1]){
                    return false;
                }
            }
        }
        else{
            for(int i=0; i<n-1; i++){
                if (nums[i] > nums[i+1]){
                    return false;
                }
            }
        }
        return true;
    }
}
