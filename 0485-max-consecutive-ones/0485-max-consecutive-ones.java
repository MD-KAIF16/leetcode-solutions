class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int mxcnt = 0;
        int ctcnt = 0;
        int n = nums.length;

        for(int j = 0 ; j < n ; j++ ){
            if(nums[j] == 1){
                ctcnt++;
            }
            else{
                mxcnt = Math.max(ctcnt , mxcnt);
                ctcnt = 0;
            }
        }

        return Math.max(ctcnt , mxcnt);

    }
}