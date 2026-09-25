class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        // Array ko sort karenge
        Arrays.sort(nums);

        int n = nums.length;

        // 1st number fix
        for (int i = 0; i < n - 3; i++) {

            // Duplicate i ko skip karo
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 2nd number fix
            for (int j = i + 1; j < n - 2; j++) {

                // Duplicate j ko skip karo
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Baaki 2 numbers ke liye 2 pointers
                int left = j + 1;
                int right = n - 1;

                while (left < right) {

                    // long use kar rahe hain kyunki numbers bade ho sakte hain
                    long sum = (long) nums[i]
                             + nums[j]
                             + nums[left]
                             + nums[right];

                    // Target mil gaya
                    if (sum == target) {

                        result.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[left],
                            nums[right]
                        ));

                        // Duplicate left values skip
                        while (left < right &&
                               nums[left] == nums[left + 1]) {
                            left++;
                        }

                        // Duplicate right values skip
                        while (left < right &&
                               nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // Next pair check karo
                        left++;
                        right--;

                    }
                    // Sum chhota hai
                    else if (sum < target) {

                        // Bada number chahiye
                        left++;

                    }
                    // Sum bada hai
                    else {

                        // Chhota number chahiye
                        right--;
                    }
                }
            }
        }

        return result;
    }
}