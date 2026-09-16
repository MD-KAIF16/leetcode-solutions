class Solution {
    public int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int prefix = 0;
        int sufix =0;
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            if(prefix == 0) prefix = 1;
            if(sufix == 0) sufix = 1;

            prefix *= nums[i];
            sufix *=nums[n-i-1];

            ans = Math.max(ans , Math.max(prefix , sufix));
        }

        return ans;
    }
}