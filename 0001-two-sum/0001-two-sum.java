
import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        // map: number → index
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int rem = target - nums[i]; // required number

            // 🔹 if already seen → answer found
            if (map.containsKey(rem)) {
                return new int[]{map.get(rem), i};
            }

            // store current number with index
            map.put(nums[i], i);
        }

        return new int[]{-1, -1}; // fallback (never used)
    }
}