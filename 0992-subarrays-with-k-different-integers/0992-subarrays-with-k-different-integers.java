class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {

        // Exactly K
        // = At Most K - At Most (K - 1)

        return atmostK(nums, k) - atmostK(nums, k - 1);
    }


    private int atmostK(int[] nums, int k) {

        int start = 0;
        int ans = 0;

        // Map stores:
        // number -> frequency inside current window

        Map<Integer, Integer> map = new HashMap<>();


        // end = right pointer of sliding window

        for (int end = 0; end < nums.length; end++) {

            // Add current element into the window
            // If element already exists, increase its frequency

            map.put(
                nums[end],
                map.getOrDefault(nums[end], 0) + 1
            );


            // If window has more than k different elements,
            // move start pointer until window becomes valid again

            while (map.size() > k) {

                // If frequency > 1,
                // just decrease its frequency

                if (map.get(nums[start]) > 1) {

                    map.put(
                        nums[start],
                        map.get(nums[start]) - 1
                    );

                }

                // If frequency == 1,
                // completely remove this number from map

                else {

                    map.remove(nums[start]);
                }

                // Move left pointer forward

                start++;
            }


            // Current window is:
            //
            // [ start ........ end ]
            //
            // Every subarray ending at 'end'
            // and starting from start to end is valid.
            //
            // Number of such subarrays = end - start + 1

            ans += (end - start + 1);
        }


        return ans;
    }
}