class Solution {

    int kadanesMax(int [] nums , int n  ){
        int mxsum = Integer.MIN_VALUE;
        int crsum = 0;
        for(int i = 0 ; i < n ; i++){
            crsum = Math.max(crsum+nums[i] , nums[i]);
            mxsum = Math.max(crsum , mxsum);
        }

        return mxsum;
    }

    int kadanesMin(int [] nums , int n  ){
        int minsum = Integer.MAX_VALUE;
        int crsum = 0;
        for(int i = 0 ; i < n ; i++){
            crsum = Math.min(crsum+nums[i] , nums[i]);
            minsum = Math.min(crsum , minsum);
        }

        return minsum;
    }
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length ;
        return Math.max(kadanesMax(nums , n) , Math.abs(kadanesMin(nums , n)));
    }
}