class Solution {
    public int pivotIndex(int[] nums) {

        // Step 1: Puri array ka total sum nikal lo
        int totalSum = 0;

        for (int num : nums) {
            totalSum += num;
        }


        // Left side ka sum initially 0 hoga
        int leftSum = 0;


        // Har index ko pivot maan kar check karenge
        for (int i = 0; i < nums.length; i++) {

            // Right side ka sum:
            // Total sum - Left side ka sum - Current element
            int rightSum = totalSum - leftSum - nums[i];


            // Agar left aur right sum equal hain
            // toh current index pivot hai
            if (leftSum == rightSum) {
                return i;
            }


            // Agle index par jaane se pehle
            // current element ko leftSum mein add kar do
            leftSum += nums[i];
        }


        // Agar koi pivot index nahi mila
        return -1;
    }
}