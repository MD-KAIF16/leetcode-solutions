
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int n = bloomDay.length;

        // Not enough flowers to make m bouquets
        if ((long) m * k > n) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Find the minimum and maximum blooming days
        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;  // Try fewer days
            } else {
                low = mid + 1;   // Need more days
            }
        }

        return ans;
    }

    private boolean canMakeBouquets(
            int[] bloomDay, int m, int k, int days) {

        int flowers = 0;
        int bouquets = 0;

        for (int day : bloomDay) {

            if (day <= days) {
                flowers++;

                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;  // Adjacency breaks
            }

            if (bouquets >= m) {
                return true;
            }
        }

        return false;
    }
}
