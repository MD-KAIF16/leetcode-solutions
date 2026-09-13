class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            // Right se element window mein add karo
            sum += nums[right];

            // Jab sum target se bada/equal ho jaye,
            // window ko chhota karne ki try karo
            while (sum >= target) {

                // Current window ki length
                ans = Math.min(ans, right - left + 1);

                // Left wala element remove karo
                sum -= nums[left];

                // Left ko aage move karo
                left++;
            }
        }

        // Agar koi valid subarray nahi mila
        if (ans == Integer.MAX_VALUE) {
            return 0;
        }

        return ans;
    }
}