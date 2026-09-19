class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int n = nums.length;
        int closest = nums[0] + nums[1] + nums[2];

        for (int l = 0; l < n - 2; l++) {

            int m = l + 1;
            int r = n - 1;

            while (m < r) {

                int sum = nums[l] + nums[m] + nums[r];

                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }

                if (sum < target) {
                    m++;
                } 
                else if (sum > target) {
                    r--;
                } 
                else {
                    return sum; // exact match
                }
            }
        }

        return closest;
    }
}