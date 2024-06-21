/*Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.*/
class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;

        reverseArray(nums, 0, nums.length-1);
        reverseArray(nums, 0, k-1);
        reverseArray(nums, k, nums.length-1);
    }

    public void reverseArray(int[] arr,int left, int right){
        while(left<=right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
