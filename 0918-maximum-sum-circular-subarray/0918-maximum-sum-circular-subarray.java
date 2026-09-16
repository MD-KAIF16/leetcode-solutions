class Solution {

    // Kadane's Algorithm -> Maximum Subarray Sum
    int kadanesMax(int[] nums, int n) {

        int sum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < n; i++) {

            // Either start a new subarray from nums[i]
            // OR continue the previous subarray
            sum = Math.max(sum + nums[i], nums[i]);

            // Store the maximum subarray sum found so far
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }


    // Kadane's Algorithm -> Minimum Subarray Sum
    int kadanesMin(int[] nums, int n) {

        int sum = nums[0];
        int minSum = nums[0];

        for (int i = 1; i < n; i++) {

            // Either start a new subarray from nums[i]
            // OR continue the previous subarray
            sum = Math.min(sum + nums[i], nums[i]);

            // Store the minimum subarray sum found so far
            minSum = Math.min(minSum, sum);
        }

        return minSum;
    }


    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;

        // 1. Calculate total sum of the array
        int SUM = 0;

        for (int num : nums) {
            SUM += num;
        }


        // 2. Find minimum subarray sum
        int minSum = kadanesMin(nums, n);


        // 3. Find maximum subarray sum
        // Case 1: Normal (non-circular) subarray
        int maxSum = kadanesMax(nums, n);


        // 4. Find maximum circular subarray sum
        //
        // Circular Sum = Total Sum - Minimum Subarray Sum
        //
        // By removing the minimum subarray,
        // the remaining elements form the maximum
        // circular subarray.
        int circularSum = SUM - minSum;


        // If maxSum > 0, there is at least one positive element.
        // So we can compare:
        //    Normal maximum subarray
        //    Circular maximum subarray
        if (maxSum > 0) {
            return Math.max(maxSum, circularSum);
        }


        // If all elements are negative,
        // circularSum becomes 0, which is invalid because
        // a subarray must contain at least one element.
        //
        // Therefore, return the normal Kadane result.
        return maxSum;
    }
}