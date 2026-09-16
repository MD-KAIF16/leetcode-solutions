class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int crSum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            crSum += nums[i];
            maxSum = Math.max(maxSum , crSum);
            if(crSum<0){
              crSum = 0;
            }
            
        }
         return maxSum;
    }
}