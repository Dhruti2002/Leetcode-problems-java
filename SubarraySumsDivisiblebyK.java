/*Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.
A subarray is a contiguous part of an array.
 */

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
       int arr[] = new int[k];
        int sum = 0;
        int count = 0;
        arr[0] = 1;
        for(int i : nums) {
            sum = (i+sum)%k;
            if(sum < 0) sum += k;
            count += arr[sum];
            arr[sum]++;
        }
        return count;
    }
}


/*class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int count = 0;
        hm.put(0, 1);
        for(int i : nums) {
            sum = (i+sum)%k;
            if(sum < 0) sum += k;
            if(hm.containsKey(sum)) count += hm.get(sum);
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        return count;
    }
}*/
