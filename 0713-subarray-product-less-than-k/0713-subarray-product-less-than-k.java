class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length ;
        int prod =  1;
        int count = 0;
        int left = 0;

        if(k<=1) return 0;

        for(int r = 0 ; r < n ; r++){
            prod = prod * nums[r];

            while(prod >= k){
                prod /= nums[left];
                left++;
            }

            count = count + (r-left+1);
        }

        return count;
    }
}