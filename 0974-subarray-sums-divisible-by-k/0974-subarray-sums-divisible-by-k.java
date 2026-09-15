class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 initially 1 baar
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;

        for (int num : nums) {

            // Prefix sum
            prefixSum += num;

            // Remainder
            int remainder = prefixSum % k;

            // Negative remainder ko positive karo
            if (remainder < 0) {
                remainder += k;
            }

            // Same remainder pehle aa chuka hai
            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }

            // Current remainder ki frequency badhao
            map.put(
                remainder,
                map.getOrDefault(remainder, 0) + 1
            );
        }

        return count;
    }
}