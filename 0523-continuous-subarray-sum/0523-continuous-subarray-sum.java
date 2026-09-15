class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {

        // remainder -> us remainder ka first index
        Map<Integer, Integer> map = new HashMap<>();

        // Starting point
        map.put(0, -1);

        int prefixSum = 0;

        for (int i = 0; i < nums.length; i++) {

            // Prefix sum calculate kar rahe hain
            prefixSum += nums[i];

            // Prefix sum ko k se divide karne par remainder
            int rem = prefixSum % k;

            // Kya ye remainder pehle aa chuka hai?
            if (map.containsKey(rem)) {

                // Purane index se current index tak
                // subarray ki length check kar rahe hain
                if (i - map.get(rem) >= 2) {

                    // Same remainder mila
                    // aur length >= 2 hai
                    return true;
                }

            } else {

                // Remainder pehli baar mila,
                // isliye uska index store kar do
                map.put(rem, i);
            }
        }

        // Koi valid subarray nahi mila
        return false;
    }
}