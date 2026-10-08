class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        // Find minimum and maximum possible capacity
        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        // Binary search for minimum valid capacity
        while (low < high) {

            int mid = low + (high - low) / 2;

            int requiredDays = 1;
            int currentWeight = 0;

            for (int weight : weights) {

                if (currentWeight + weight > mid) {
                    // Start a new day
                    requiredDays++;
                    currentWeight = 0;
                }

                currentWeight += weight;
            }

            // If this capacity needs too many days
            if (requiredDays > days) {
                low = mid + 1;
            } 
            else {
                // Capacity works, try smaller
                high = mid;
            }
        }

        return low;
    }
}