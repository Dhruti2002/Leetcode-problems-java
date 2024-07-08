class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        // Calculate the total sum of all card points
        for(int points: cardPoints){
            totalSum += points;
        }

        // Find the minimum sum of a subarray of length n - k
        int subarrayLength = n-k;
        int minSubarraySum =0;
        int currentSubarraySum =0;

        // Calculate the sum of the first subarray of length n - k
        for (int i=0; i<subarrayLength; i++){
            currentSubarraySum += cardPoints[i];
        }
        minSubarraySum = currentSubarraySum ;


        // Use a sliding window to find the minimum subarray sum of length n - k
        for (int i = subarrayLength; i < n; i++) {
            currentSubarraySum += cardPoints[i] - cardPoints[i - subarrayLength];
            minSubarraySum = Math.min(minSubarraySum, currentSubarraySum);
        }

        // The maximum score is the total sum minus the minimum subarray sum
        return totalSum - minSubarraySum;
    }
}
