
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {

        int n = dist.length;

        // Impossible to reach if hour is less than n - 1
        if (hour <= n - 1) {
            return -1;
        }

        int low = 1;
        int high = 10_000_000;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(dist, mid, hour)) {
                ans = mid;
                high = mid - 1; // Try a smaller speed
            } else {
                low = mid + 1;  // Need a faster speed
            }
        }

        return ans;
    }

    private boolean canReach(int[] dist, int speed, double hour) {

        double time = 0;

        for (int i = 0; i < dist.length; i++) {

            if (i == dist.length - 1) {
                time += (double) dist[i] / speed;
            } else {
                // Every train except the last must depart
                // at an integer hour
                time += Math.ceil((double) dist[i] / speed);
            }
        }

        return time <= hour;
    }
}
